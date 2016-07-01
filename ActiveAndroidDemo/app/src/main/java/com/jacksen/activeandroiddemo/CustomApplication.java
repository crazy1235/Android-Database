package com.jacksen.activeandroiddemo;

import android.app.Application;

import com.activeandroid.ActiveAndroid;
import com.activeandroid.Configuration;

/**
 * Created by Admin on 2016/6/29.
 */

public class CustomApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化

        Configuration.Builder builder = new Configuration.Builder(this);
        builder.setSqlParser(Configuration.SQL_PARSER_DELIMITED);
        Configuration configuration = builder.create();
        ActiveAndroid.initialize(configuration);

//        ActiveAndroid.initialize(this);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        //清理
        ActiveAndroid.dispose();
    }
}
