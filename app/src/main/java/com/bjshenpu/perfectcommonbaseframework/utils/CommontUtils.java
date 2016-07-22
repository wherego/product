package com.bjshenpu.perfectcommonbaseframework.utils;

import android.os.Environment;

import java.io.File;

/**
 * Created by  Quentin on  2016/7/21 16:54
 **/
public class CommontUtils {

    /**
     * 创建Apk文件下载目录
     * @return
     */
    public static File createApkFileDir() {

        if(!SDCardUtils.isSDCardEnable())
        {
            ToastUtil.showToast("当前无SDcard,请确认存在外部内存卡...");
            return null;
        }

        File tmpDir = new File(Environment.getExternalStorageDirectory() + "/com.bjshenpu.esales");
        if (!tmpDir.exists()) {
            //创建目录
            tmpDir.mkdir();
        }
        return tmpDir;
    }

}
