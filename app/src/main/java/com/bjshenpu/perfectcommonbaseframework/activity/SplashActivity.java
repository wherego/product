package com.bjshenpu.perfectcommonbaseframework.activity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Button;
import com.bjshenpu.perfectcommonbaseframework.R;
import com.bjshenpu.perfectcommonbaseframework.base.MvpActivity;
import com.bjshenpu.perfectcommonbaseframework.constant.ExtraName;
import com.bjshenpu.perfectcommonbaseframework.model.UpDateInfoEntity;
import com.bjshenpu.perfectcommonbaseframework.presenter.SplashPresenter;
import com.bjshenpu.perfectcommonbaseframework.utils.SpUtils;
import com.bjshenpu.perfectcommonbaseframework.view.SplashView;
import java.io.File;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by  Quentin on  2016/7/21 14:26
 **/
public class SplashActivity extends MvpActivity<SplashPresenter> implements SplashView {
    private static final String TAG = "SplashActivity";

    @Bind(R.id.btn_splash_timer)
    Button btnSplashTimer;


    private ProgressDialog pd;
    int mLastTimer = 3;

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (mLastTimer == 0) {

                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                SplashActivity.this.finish();
                return;
            }
            mLastTimer--;
            btnSplashTimer.setText(mLastTimer + "");
            handler.sendEmptyMessageDelayed(0, 1000);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        initProgressDialog();
        // mvpPresenter.getApkInfo();
        //如果是第一次登陆，跳转到向导页面
        if (SpUtils.getBoolean(ExtraName.FIRST_ENTERED, false)) {
            //如果不是第一次登陆
            handler.sendEmptyMessageDelayed(0, 1000);
        } else {
            startActivity(new Intent(this, GuideActivity.class));
            finish();
        }
    }

    @Override
    protected SplashPresenter createPresenter() {
        return new SplashPresenter(this);
    }


    @Override
    public void getDataSuccess(UpDateInfoEntity model) {
        if (Integer.parseInt(model.getErrorCode()) == 200) {
            showUpdateDialog(model.getPath());
        }
    }

    @Override
    public void getDataFail(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }


    @Override
    public void showDownLoading() {
        pd.show();
    }

    /**
     * 初始化dialog
     */
    private void initProgressDialog() {
        pd = new ProgressDialog(this);
        pd.setCancelable(false);
        pd.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pd.setMessage("正在下载更新");
    }

    /**
     * 隐藏下载框
     */
    @Override
    public void hideDownLoading() {
        pd.dismiss();
    }

    /**
     * 设置progress 进度
     *
     * @param progress
     */
    @Override
    public void setProgress(float progress) {
        pd.setProgress((int) (100 * progress));
    }

    /**
     * APK下载完成
     *
     * @param file
     */
    @Override
    public void downLoadComplete(File file) {
        installAPK(file);
    }

    /**
     * 下载APK时访问服务器异常
     *
     * @param e
     */
    @Override
    public void downLoadServletFaild(Exception e) {
        Log.e(TAG, e.getMessage());

    }

    /**
     * 下载Apk时创建文件失败
     */
    @Override
    public void createFileFaild() {

    }


    /**
     * 下载更新对话框
     *
     * @param path
     */
    protected void showUpdateDialog(final String path) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setTitle("软件版本更新");
        builder.setMessage("有最新的软件包哦，赶快下载吧~");
        builder.setCancelable(false);

        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                mvpPresenter.downloadApk(path);
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startLoginActivity();
            }
        });

        builder.show();
    }

    /**
     * apk 安装
     */
    public void installAPK(File file) {

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        this.startActivity(intent);
        //关闭当前页面
        finish();
    }


    /**
     * 进入登录页面
     */
    private void startLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeMessages(0);
        handler = null;
    }

}
