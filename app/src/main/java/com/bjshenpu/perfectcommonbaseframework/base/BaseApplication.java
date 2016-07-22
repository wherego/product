package com.bjshenpu.perfectcommonbaseframework.base;

import android.app.Application;
import android.content.Context;


/**
 * ============================================================
 * <p/>
 * 版 权 ：
 * <p/>
 * 作 者 : Quentin
 * <p/>
 * 版 本 ： 1.0
 * <p/>
 * 创建日期 ： 2016/1/30 12:40
 * <p/>
 * 描 述 ：
 * <p/>
 * ============================================================
 **/
public class BaseApplication extends Application{


    private static Context mContext;


    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
      //  OkHttpUtils.getInstance().debug("testDebug").setConnectTimeout(100000, TimeUnit.MILLISECONDS);


    }


    public static Context getContext() {
        return mContext;
    }
}
