package com.bjshenpu.perfectcommonbaseframework.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.bjshenpu.perfectcommonbaseframework.base.BaseFragment;

import java.util.List;

/**
 * Created by  Quentin on  2016/6/29 11:13
 **/
public class MyPageAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> mPageFragments;

    public MyPageAdapter(FragmentManager fm, List<BaseFragment> fragments) {
        super(fm);
        this.mPageFragments = fragments;
    }

    @Override
    public int getCount() {
        return mPageFragments.size();
    }

    @Override
    public Fragment getItem(int position) {
        return mPageFragments.get(position);
    }

    //Remove a page for the given position. The adapter is responsible for removing the view from its container
    //防止重新销毁视图
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //如果注释这行，那么不管怎么切换，page都不会被销毁
        //super.destroyItem(container, position, object);
    }



}