package com.bjshenpu.perfectcommonbaseframework.presenter;

import com.bjshenpu.perfectcommonbaseframework.base.BasePresenter;
import com.bjshenpu.perfectcommonbaseframework.view.MainView;

/**
 * Created by  Quentin on  2016/7/19 15:26
 **/
public class MainPresenter extends BasePresenter {

    public MainPresenter(MainView view) {
        attachView(view);
    }

}
