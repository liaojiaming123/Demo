package com.example.common;

import android.app.Application;
import android.content.Context;

//import com.sankuai.waimai.router.Router;
//import com.sankuai.waimai.router.common.DefaultRootUriHandler;

import com.didi.drouter.api.DRouter;

//import com.alibaba.android.arouter.launcher.ARouter;

public class BaseApplication extends Application {
    public static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
//        ARouter.openLog();
//        ARouter.openDebug();
//        ARouter.init(BaseApplication.this);
//        Utils.init(BaseApplication.this);
        DRouter.init(this);
        // 创建RootHandler
//        DefaultRootUriHandler rootHandler = new DefaultRootUriHandler(context);

// 初始化
//        Router.init(rootHandler);

    }
    public static Context getContext(){
        return context;
    }

}

