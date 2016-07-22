package com.bjshenpu.perfectcommonbaseframework.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.bjshenpu.perfectcommonbaseframework.R;
import com.bjshenpu.perfectcommonbaseframework.base.MvpActivity;
import com.bjshenpu.perfectcommonbaseframework.model.LoginEntity;
import com.bjshenpu.perfectcommonbaseframework.presenter.LoginPresenter;
import com.bjshenpu.perfectcommonbaseframework.view.LoginView;
import butterknife.Bind;

/**
 * Created by  Quentin on  2016/7/19 13:52
 **/
public class LoginActivity extends MvpActivity<LoginPresenter> implements LoginView {

    private static final String TAG = "LoginActivity";
    @Bind(R.id.et_login_username)
    EditText etLoginUsername;
    @Bind(R.id.et_login_pwd)
    EditText etLoginPwd;
    @Bind(R.id.btn_login_submit)
    Button btnLoginSubmit;
    @Bind(R.id.tv_show)
    TextView tvShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLoginSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG,"button");
                String username = etLoginUsername.getText().toString().trim();
                String password = etLoginPwd.getText().toString().trim();
                //进行数据加载
                mvpPresenter.loadData(username,password);
            }
        });
    }

    @Override
    public void getDataSuccess(LoginEntity model) {
        Log.e(TAG, "model :" + model.getErrorCode());
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

    @Override
    public void getDataFail(String msg) {
        Log.e(TAG, "msg :" + msg);

    }

    @Override
    public void showLoading() {
        tvShow.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        tvShow.setVisibility(View.GONE);
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this);
    }
}
