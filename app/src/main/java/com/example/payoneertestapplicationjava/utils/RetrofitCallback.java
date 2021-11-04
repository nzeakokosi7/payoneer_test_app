package com.example.payoneertestapplicationjava.utils;

import android.content.Context;
import android.widget.Toast;

import com.example.payoneertestapplicationjava.PayoneerTestApp;
import com.example.payoneertestapplicationjava.R;
import com.google.gson.JsonSyntaxException;

import org.json.JSONException;

import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public abstract class RetrofitCallback<T> implements Callback<T> {
    private final Context context;
    private boolean validateResponse = true;

    public RetrofitCallback(boolean validateResponse) {
        this.context = PayoneerTestApp.getAppContext();
        this.validateResponse = validateResponse;
    }
    public abstract void onSuccess(T arg0);
    @Override
    public void onResponse(Call<T> call, Response<T> response) {

        if (response.isSuccessful() && response.code() == 200) {
            onSuccess(response.body());
        } else {
            Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onFailure(Call<T> call, Throwable error) {
        if (!validateResponse)
            return;    String errorMsg;
        error.printStackTrace();
        if (error instanceof SocketTimeoutException) {
            errorMsg = context.getString(R.string.connection_timeout);
        } else if (error instanceof UnknownHostException) {
            errorMsg = context.getString(R.string.nointernet);
        } else if (error instanceof ConnectException) {
            errorMsg = context.getString(R.string.server_not_responding);
        } else if (error instanceof JSONException || error instanceof JsonSyntaxException) {
            errorMsg = context.getString(R.string.parse_error);
        } else if (error instanceof IOException) {
            errorMsg = error.getMessage();
        } else {
            errorMsg = context.getString(R.string.something_wrong);
        }
        Toast.makeText(context, errorMsg, Toast.LENGTH_SHORT).show();
    }
}
