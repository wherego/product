package com.bjshenpu.perfectcommonbaseframework.presenter;

import android.util.Log;
import com.bjshenpu.perfectcommonbaseframework.base.BasePresenter;
import com.bjshenpu.perfectcommonbaseframework.model.LoginEntity;
import com.bjshenpu.perfectcommonbaseframework.rxjava.ApiCallback;
import com.bjshenpu.perfectcommonbaseframework.rxjava.SubscriberCallBack;
import com.bjshenpu.perfectcommonbaseframework.view.LoginView;

/**
 * Created by  Quentin on  2016/7/19 13:53
 **/
public class LoginPresenter extends BasePresenter<LoginView> {
    private static final String TAG ="LoginPresenter" ;

    public LoginPresenter(LoginView view) {
        attachView(view);
    }

    public void loadData(String username,String password) {
        Log.e(TAG,"LoginPresenter ---->   username :"+username +"   password :"+password);
        mvpView.showLoading();
        addSubscription(apiStores.login("01","1.0.2"),
                new SubscriberCallBack<>(new ApiCallback<LoginEntity>() {
                    @Override
                    public void onSuccess(LoginEntity model) {
                        mvpView.getDataSuccess(model);
                    }

                    @Override
                    public void onFailure(int code, String msg) {
                        mvpView.getDataFail(msg);
                    }

                    @Override
                    public void onCompleted() {
                        mvpView.hideLoading();
                    }
                }));
    }

}
