package com.bjshenpu.perfectcommonbaseframework.view;

import com.bjshenpu.perfectcommonbaseframework.model.LoginEntity;

/**
 * Created by  Quentin on  2016/7/19 13:59
 **/
public interface LoginView {
    void getDataSuccess(LoginEntity model);

    void getDataFail(String msg);

    void showLoading();

    void hideLoading();
}
