package com.bjshenpu.perfectcommonbaseframework.utils;


import android.widget.Toast;

import com.bjshenpu.perfectcommonbaseframework.base.BaseApplication;


/**
 * ============================================================
 * <p/>
 * 版 权 ：
 * <p/>
 * 作 者 : Quentin
 * <p/>
 * 版 本 ： 1.0
 * <p/>
 * 创建日期 ： 2015/12/1 22:20
 * <p/>
 * 描 述 ：Toast工具类
 * <p/>
 * ============================================================
 **/
public class ToastUtil {
	private static Toast toast;
	/**
	 * @param text
	 */

	public static void showToast(String text){
		if(toast==null){
			toast = Toast.makeText(BaseApplication.getContext(), text, Toast.LENGTH_SHORT);
		}
		toast.setText(text);
		toast.show();
	}
}
