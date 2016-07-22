package com.bjshenpu.perfectcommonbaseframework.presenter;

import com.bjshenpu.perfectcommonbaseframework.base.BasePresenter;
import com.bjshenpu.perfectcommonbaseframework.model.UpDateInfoEntity;
import com.bjshenpu.perfectcommonbaseframework.retrofit.HttpConfig;
import com.bjshenpu.perfectcommonbaseframework.rxjava.ApiCallback;
import com.bjshenpu.perfectcommonbaseframework.rxjava.SubscriberCallBack;
import com.bjshenpu.perfectcommonbaseframework.utils.CommontUtils;
import com.bjshenpu.perfectcommonbaseframework.view.SplashView;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.FileCallBack;
import java.io.File;
import okhttp3.Request;

/**
 * Created by  Quentin on  2016/7/19 13:53
 **/
public class SplashPresenter extends BasePresenter<SplashView> {
    private static final String TAG = "LoginPresenter";

    public SplashPresenter(SplashView view) {
        attachView(view);
    }


    public void getApkInfo() {
        mvpView.showLoading();
        addSubscription(apiStores.getApkInfo("01", "1.0.2"),
                new SubscriberCallBack<>(new ApiCallback<UpDateInfoEntity>() {
                    @Override
                    public void onSuccess(UpDateInfoEntity model) {
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

    /**
     * 此处使用okhttputils来下载文件，因为用retrofit比较鸡肋
     * tip：http://blog.csdn.net/lmj623565791/article/details/51304204
     *
     * @param apkPath
     */
    public void downloadApk(String apkPath) {
        mvpView.showDownLoading();
        if (CommontUtils.createApkFileDir() == null) {

            mvpView.createFileFaild();
            return;
        }

        OkHttpUtils
                .get()
                .url(HttpConfig.BASE_HOST_URL + apkPath)
                .build()
                .execute(new FileCallBack(CommontUtils.createApkFileDir().getAbsolutePath(), "esales.apk") //存在的路径，和文件的名字
                {
                    @Override
                    public void inProgress(float progress) {
                        mvpView.setProgress(progress);
                    }

                    @Override
                    public void onError(Request request, Exception e) {

                        mvpView.downLoadServletFaild(e);
                        mvpView.hideDownLoading();
                    }

                    @Override
                    public void onResponse(File file) {
                        mvpView.downLoadComplete(file);
                        mvpView.hideDownLoading();
                    }
                });
    }

}
