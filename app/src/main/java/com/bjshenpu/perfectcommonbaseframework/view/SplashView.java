package com.bjshenpu.perfectcommonbaseframework.view;

import com.bjshenpu.perfectcommonbaseframework.model.UpDateInfoEntity;

import java.io.File;

/**
 * Created by  Quentin on  2016/7/19 15:26
 **/
public interface SplashView {
    void getDataSuccess(UpDateInfoEntity model);

    void getDataFail(String msg);

    void showLoading();

    void hideLoading();

    void showDownLoading();

    void hideDownLoading();

    void setProgress(float progress);

    void downLoadComplete(File file);

    void downLoadServletFaild(Exception e);

    void createFileFaild();
}
