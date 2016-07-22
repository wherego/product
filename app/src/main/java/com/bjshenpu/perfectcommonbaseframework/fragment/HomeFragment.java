package com.bjshenpu.perfectcommonbaseframework.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.bjshenpu.perfectcommonbaseframework.R;
import com.bjshenpu.perfectcommonbaseframework.adapter.BannerAdapter;
import com.bjshenpu.perfectcommonbaseframework.adapter.PersonAdapter;
import com.bjshenpu.perfectcommonbaseframework.base.MvpFragment;
import com.bjshenpu.perfectcommonbaseframework.model.LoginEntity;
import com.bjshenpu.perfectcommonbaseframework.presenter.HomePresenter;
import com.bjshenpu.perfectcommonbaseframework.utils.DensityUtils;
import com.bjshenpu.perfectcommonbaseframework.utils.NetUtils;
import com.bjshenpu.perfectcommonbaseframework.view.LoginView;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.rollviewpager.RollPagerView;
import com.jude.rollviewpager.hintview.ColorPointHintView;
import java.util.ArrayList;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by  Quentin on  2016/7/19 15:39
 **/
public class HomeFragment extends MvpFragment<HomePresenter> implements LoginView, RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    public static final String HOMEFRAGMENT_LOAD = "HomeFragmentLoad";
    private static final String TAG = "HomeFragment";
    @Bind(R.id.recyclerView)
    EasyRecyclerView recyclerView;

    private PersonAdapter adapter;
    private ArrayList<String> arrayList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // TODO: 2016/7/20 该fragment不需要懒加载,使用页面初始化默认加载,此处做加载数据操作
        Log.e(TAG, "HOMEFRAGMENT_LOAD 可以加载数据了");
        arrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            arrayList.add("hello--->" + i);
        }

        setRecycleViewAndAdapter();
        //默认刷新一次
        onRefresh();
    }

    /**
     * 初始化recycle和设置adapter
     */
    private void setRecycleViewAndAdapter() {
        recyclerView.setLayoutManager(new LinearLayoutManager(mActivity));
        recyclerView.setAdapterWithProgress(adapter = new PersonAdapter(mActivity));
        //设置加载更多页面
        adapter.setMore(R.layout.view_more, this);
        //设置没有更多页面
        adapter.setNoMore(R.layout.view_nomore);
        //设置错误页面
        recyclerView.setErrorView(R.layout.view_error);
        //设置Item的点击事件
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Log.e(TAG, "position :" + position);
            }
        });

        //设置点击之后的错误页面
        adapter.setError(R.layout.view_error).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.resumeMore();
            }
        });


        /**
         * 设置轮播图
         */
        adapter.addHeader(new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                //此处使用第三方滚动轮播图库
                RollPagerView header = new RollPagerView(mActivity);
                header.setHintView(new ColorPointHintView(mActivity, Color.YELLOW, Color.GRAY));
                header.setHintPadding(0, 0, 0, DensityUtils.dp2px(mActivity, 8));
                header.setPlayDelay(2000);
                header.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, DensityUtils.dp2px(mActivity, 200)));
                header.setAdapter(new BannerAdapter(mActivity));
                return header;
            }

            @Override
            public void onBindView(View headerView) {

            }
        });
        recyclerView.setRefreshListener(this);
    }


    @Override
    public void getDataSuccess(LoginEntity model) {

        // TODO: 2016/7/20 此处必须使用延迟一秒，否则会报错
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //刷新
                // TODO: 2016/7/20 检测网络

                if (!NetUtils.isConnected(mActivity)) {
                    adapter.pauseMore();
                    return;
                }
                ArrayList<String> arrayList = new ArrayList<String>();
                arrayList.add("add more");
                adapter.addAll(arrayList);
            }
        }, 1000);


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
    protected HomePresenter createPresenter() {
        return new HomePresenter(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }

    /**
     * 第一页默认不需要懒加载
     */
    @Override
    protected void lazyLoad() {

    }

    private Handler handler = new Handler();
    @Override
    public void onLoadMore() {

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //刷新
                if (!NetUtils.isConnected(mActivity)) {
                    adapter.pauseMore();
                    return;
                }
                Log.e(TAG,"arrayList :"+arrayList.size());
                if(arrayList.size()==20)
                {
                    //当没有数据时，可以调用该方法
                    adapter.stopMore();
                    return;
                }
                adapter.addAll(arrayList);
            }
        }, 1000);
    }

    @Override
    public void onRefresh() {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                adapter.clear();
                //刷新
                if (!NetUtils.isConnected(mActivity)) {
                    adapter.pauseMore();
                    return;
                }
                adapter.addAll(arrayList);
            }
        }, 1000);
    }
}

