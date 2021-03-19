package com.example.myapp.application;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.appcompat.app.AppCompatDelegate;

public class HomeApplication extends Application {

    private static HomeApplication instance;
    private static Context appContext;

    public static HomeApplication getInstance() { return instance; }

    public static Context getAppContext() {
        return appContext;
    }

    public void setAppContext(Context appContext) {
        HomeApplication.appContext = appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance=this;
        Log.d("InitApp","Наш додаток створено");
        this.setAppContext(getApplicationContext());
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}
