package com.jacksen.activeandroiddemo;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by Admin on 2016/6/29.
 */

public class CustomApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化
        ActiveAndroid.initialize(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        //清理
        ActiveAndroid.dispose();
    }
}
