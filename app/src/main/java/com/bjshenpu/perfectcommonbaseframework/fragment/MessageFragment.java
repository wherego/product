package com.bjshenpu.perfectcommonbaseframework.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.bjshenpu.perfectcommonbaseframework.R;
import com.bjshenpu.perfectcommonbaseframework.base.MvpFragment;
import com.bjshenpu.perfectcommonbaseframework.model.LoginEntity;
import com.bjshenpu.perfectcommonbaseframework.presenter.HomePresenter;
import com.bjshenpu.perfectcommonbaseframework.utils.SpUtils;
import com.bjshenpu.perfectcommonbaseframework.view.LoginView;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by  Quentin on  2016/7/19 15:39
 **/
public class MessageFragment extends MvpFragment<HomePresenter> implements LoginView {
    private static final String TAG = "MessageFragment";
    @Bind(R.id.probar)
    ProgressBar probar;

    /**
     * 是否已被加载过一次，第二次就不再去请求数据了
     */
    private boolean mHasLoadedOnce;
    private boolean isPrepared;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_message, null);
        ButterKnife.bind(this, view);
        isPrepared = true;
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void getDataSuccess(LoginEntity model) {

    }

    @Override
    public void getDataFail(String msg) {

    }

    @Override
    public void showLoading() {
        probar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        probar.setVisibility(View.GONE);
    }

    @Override
    protected HomePresenter createPresenter() {
        return new HomePresenter(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible || mHasLoadedOnce) {
            return;
        } else {
            mHasLoadedOnce = true;
            // TODO: 2016/7/20 此处做加载数据操作
            //填充各控件的数据
            Log.e(TAG, "MessageFragment 可以加载数据了");
        }
    }

}
