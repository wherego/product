package com.bjshenpu.perfectcommonbaseframework.utils;

import android.util.Log;

/**
 * ============================================================
 *
 * 描 述 ：Log统一管理类
 *
 * ============================================================
 **/
public class AppLog {

    public static final String HTTP = "HTTP";
    public static final String DB = "DB";
    public static final String UI = "APP_UI";
    public static final String JS = "JS";

    private AppLog() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");
    }
    private static final String sPrefix = "XunJi_";


    public static boolean isDebug = true;// 是否需要打印bug，可以在application的onCreate函数里面初始化
    private static final String TAG = "way";

    // 下面四个是默认tag的函数
    public static void i(String msg) {
        if (isDebug)
            Log.i(TAG, msg);
    }

    public static void d(String msg) {
        if (isDebug)
            Log.d(TAG, msg);
    }

    public static void e(String msg) {
        if (isDebug)
            Log.e(TAG, msg);
    }

    public static void v(String msg) {
        if (isDebug)
            Log.v(TAG, msg);
    }

    // 下面是传入自定义tag的函数
    public static void i(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (isDebug)
            Log.d(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            Log.e(tag, msg);
    }



    public static void v(String tag, String msg) {
        if (isDebug)
            Log.v(tag, msg);
    }
}

