package com.bjshenpu.perfectcommonbaseframework.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import butterknife.ButterKnife;


public abstract class BaseFragment extends Fragment {

    public Activity mActivity;
    protected boolean isVisible;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        mActivity = getActivity();
    }


    /**Fragment 显示或隐藏 时被调用*/
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    /**
     * 显示时
     */
    protected void onVisible(){
        lazyLoad();
    }

    protected abstract void lazyLoad();

    /**
     * 隐藏时
     */
    public void onInvisible(){}



    @Override
    public void onDestroy() {
        super.onDestroy();
      //  onUnsubscribe();
    }

//    private CompositeSubscription mCompositeSubscription;
//
//    public void onUnsubscribe() {
//        //取消注册，以避免内存泄露
//        if (mCompositeSubscription != null) {
//            mCompositeSubscription.unsubscribe();
//        }
//    }
//
//    public void addSubscription(Subscription subscription) {
////        if (mCompositeSubscription == null) {
//        mCompositeSubscription = new CompositeSubscription();
////        }
//        mCompositeSubscription.add(subscription);
//    }

}



//    public Toolbar initToolBar(View view, String title) {
//        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
//        TextView toolbar_title = (TextView) toolbar.findViewById(R.id.toolbar_title);
//        toolbar_title.setText(title);
//        return toolbar;
//    }
