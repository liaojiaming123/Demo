package com.example.common;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.launcher.ARouter;

public class BaseApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        ARouter.openLog();
        ARouter.openDebug();
        ARouter.init(BaseApplication.this);
//        Utils.init(BaseApplication.this);
    }
    public static Context getContext(){
        return context;
    }

}

