package com.bjshenpu.perfectcommonbaseframework.utils;


import android.content.SharedPreferences;

import com.bjshenpu.perfectcommonbaseframework.base.BaseApplication;


/**
 * ============================================================
 * <p/>
 * 版 权 ：
 * <p/>
 * 作 者 :Quentin
 * <p/>
 * 版 本 ： 1.0
 * <p/>
 * 创建日期 ： 2015/12/1 22:20
 * <p/>
 * 描 述 ：SharedPreferences 工具类
 * <p/>
 * ============================================================
 **/
public class SpUtils {


	private static SharedPreferences sp;

	private static final String SP_NAME = "config";

	public static void saveString(String key, String value) {
		if (sp == null)
			sp = BaseApplication.getContext().getSharedPreferences(SP_NAME, 0);
		sp.edit().putString(key, value).commit();
	}

	public static String getString(String key, String defValue) {
		if (sp == null)
			sp = BaseApplication.getContext().getSharedPreferences(SP_NAME, 0);
		return sp.getString(key, defValue);
	}
	public static void saveBoolean(String key, boolean value) {
		if (sp == null)
			sp = BaseApplication.getContext().getSharedPreferences(SP_NAME, 0);
		sp.edit().putBoolean(key, value).commit();
	}

	public static boolean getBoolean( String key, boolean defValue) {
		if (sp == null)
			sp = BaseApplication.getContext().getSharedPreferences(SP_NAME, 0);
		return sp.getBoolean(key, defValue);
	}
}
