package com.example.payoneertestapplicationjava;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class PayoneerTestApp extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();

        PayoneerTestApp.context = getApplicationContext();

    }

    public static Context getAppContext() {
        return context;
    }

    public static Boolean hasNetwork() {
        boolean isConnected = false;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();

        if (activeNetwork != null && activeNetwork.isConnected()) {
            isConnected = true;
        }
        return isConnected;
    }
}
