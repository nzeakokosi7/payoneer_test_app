package com.example.payoneertestapplicationjava.utils;

import android.content.Context;

import com.example.payoneertestapplicationjava.PayoneerTestApp;
import com.example.payoneertestapplicationjava.dao.ApiInterface;

import java.io.IOException;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitService {
    private static Retrofit cacheEnabledRetrofit(final Context context) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .cache(new Cache(context.getCacheDir(), 5 * 1024 * 1024))
                .addInterceptor(new Interceptor() {
                    @Override
                    public okhttp3.Response intercept(Chain chain) throws IOException {
                        Request request = chain.request();
                        if(PayoneerTestApp.hasNetwork())
                            request = request.newBuilder().header("Cache-Control", "public, max-age=" + 60).build();
                        else
                            request = request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build();
                        return chain.proceed(request);
                    }
                })
                .build();

        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl("https://raw.githubusercontent.com/optile/checkout-android/develop/shared-test/")
                .build();
    }

    public static ApiInterface getInterface() {
        return cacheEnabledRetrofit(PayoneerTestApp.getAppContext()).create(ApiInterface.class);
    }
}
