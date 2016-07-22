package com.bjshenpu.perfectcommonbaseframework.activity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.bjshenpu.perfectcommonbaseframework.R;
import com.bjshenpu.perfectcommonbaseframework.adapter.MyPageAdapter;
import com.bjshenpu.perfectcommonbaseframework.base.BaseFragment;
import com.bjshenpu.perfectcommonbaseframework.base.MvpActivity;
import com.bjshenpu.perfectcommonbaseframework.component.MutiComponent;
import com.bjshenpu.perfectcommonbaseframework.component.SimpleComponent;
import com.bjshenpu.perfectcommonbaseframework.constant.ExtraName;
import com.bjshenpu.perfectcommonbaseframework.fragment.HomeFragment;
import com.bjshenpu.perfectcommonbaseframework.fragment.LoggerFragment;
import com.bjshenpu.perfectcommonbaseframework.fragment.MessageFragment;
import com.bjshenpu.perfectcommonbaseframework.fragment.MineFragment;
import com.bjshenpu.perfectcommonbaseframework.model.LoginEntity;
import com.bjshenpu.perfectcommonbaseframework.presenter.MainPresenter;
import com.bjshenpu.perfectcommonbaseframework.utils.SpUtils;
import com.bjshenpu.perfectcommonbaseframework.view.MainView;
import com.bjshenpu.perfectcommonbaseframework.widget.CustomViewPager;
import com.blog.www.guideview.Component;
import com.blog.www.guideview.Guide;
import com.blog.www.guideview.GuideBuilder;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends MvpActivity<MainPresenter> implements MainView, RadioGroup.OnCheckedChangeListener {
    private static final String TAG = "MainActivity";
    private ArrayList<BaseFragment> pages;
    //首页
    @Bind(R.id.rb_bottombar_home)
    RadioButton rbBottombarHome;
    //消息
    @Bind(R.id.rb_bottombar_message)
    RadioButton rbBottombarMessage;
    //日志
    @Bind(R.id.rb_bottombar_logging)
    RadioButton rbBottombarLogging;
    //我
    @Bind(R.id.rb_bottombar_mine)
    RadioButton rbBottombarMine;
    @Bind(R.id.group)
    RadioGroup group;
    //ViewPage,用于存放fragment
    @Bind(R.id.vp_main_viewpager)
    CustomViewPager vpMainViewpager;

    private HomeFragment homefragment;
    private MessageFragment messageFragment;
    private LoggerFragment loggerFragment;
    private MineFragment mineFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initFragment();
        //设置按钮点击事件,默认设置首页被选中
        group.setOnCheckedChangeListener(this);
        rbBottombarHome.setChecked(true);

        setPop();
    }

    /**
     * 设置是否弹窗,一般情况下，是第一次安装，或出现新功能时会出现，可选。
     */
    private void setPop() {
        if (!SpUtils.getBoolean(ExtraName.FIRST_SHOWPOP, false)) {
            vpMainViewpager.post(new Runnable() {
                @Override
                public void run() {
                    showGuideView();
                }
            });
            SpUtils.saveBoolean(ExtraName.FIRST_SHOWPOP, true);
        }
    }

    /**
     * 初始化fragment布局,并且添加
     */
    private void initFragment() {
        homefragment = new HomeFragment();
        messageFragment = new MessageFragment();
        loggerFragment = new LoggerFragment();
        mineFragment = new MineFragment();

        pages = new ArrayList<>();
        pages.add(homefragment);
        pages.add(messageFragment);
        pages.add(loggerFragment);
        pages.add(mineFragment);

        //tips:默认让viewpage把所有的页面都加载出来，注意，此处并没有加载数据，数据使用懒加载，所有不会产生什么影响
        vpMainViewpager.setOffscreenPageLimit(3);
        //设置adapter
        vpMainViewpager.setAdapter(new MyPageAdapter(getSupportFragmentManager(), pages));

    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public void getDataSuccess(LoginEntity model) {

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
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        //选择显示点击了的fragment，去掉viewpage动画
        switch (checkedId) {
            case R.id.rb_bottombar_home:
                vpMainViewpager.setCurrentItem(0, false);
                break;
            case R.id.rb_bottombar_message:
                vpMainViewpager.setCurrentItem(1, false);
                break;
            case R.id.rb_bottombar_logging:
                vpMainViewpager.setCurrentItem(2, false);
                break;
            case R.id.rb_bottombar_mine:
                vpMainViewpager.setCurrentItem(3, false);
                break;
        }
    }

    /**
     * 两次返回退出
     */
    private long firstTime = 0;

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        // TODO Auto-generated method stub
        switch (keyCode) {
            case KeyEvent.KEYCODE_BACK:
                long secondTime = System.currentTimeMillis();
                if (secondTime - firstTime > 2000) {                                         //如果两次按键时间间隔大于2秒，则不退出
                    Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    firstTime = secondTime;//更新firstTime
                    return true;
                } else {                                                    //两次按键小于2秒时，退出应用
                    System.exit(0);
                }
                break;
        }
        return super.onKeyUp(keyCode, event);
    }


    public void showGuideView() {
        GuideBuilder builder = new GuideBuilder();
        builder.setTargetView(rbBottombarMine)
                .setAlpha(150)
                .setHighTargetCorner(20)
                .setOverlayTarget(false)
                .setOutsideTouchable(false);
        builder.setOnVisibilityChangedListener(new GuideBuilder.OnVisibilityChangedListener() {
            @Override
            public void onShown() {
                // Toast.makeText(SimpleGuideViewActivity.this, "show", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onDismiss() {
                // Toast.makeText(SimpleGuideViewActivity.this, "dismiss", Toast.LENGTH_SHORT)
                // .show();
                showGuideView2();
            }
        });

        builder.addComponent(new SimpleComponent());
        Guide guide = builder.createGuide();
        guide.setShouldCheckLocInWindow(false);
        guide.show(this);
    }


    public void showGuideView2() {
        final GuideBuilder builder1 = new GuideBuilder();
        builder1.setTargetView(rbBottombarMessage)
                .setAlpha(150)
                .setHighTargetGraphStyle(Component.CIRCLE)
                .setOverlayTarget(false)
                .setExitAnimationId(android.R.anim.fade_out)
                .setOutsideTouchable(false);
        builder1.setOnVisibilityChangedListener(new GuideBuilder.OnVisibilityChangedListener() {
            @Override
            public void onShown() {
                //Toast.makeText(MutiGuideViewActivity.this, "show", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onDismiss() {
                //Toast.makeText(MutiGuideViewActivity.this, "dismiss", Toast.LENGTH_SHORT).show();
            }
        });

        builder1.addComponent(new MutiComponent());
        Guide guide = builder1.createGuide();
        guide.setShouldCheckLocInWindow(false);
        guide.show(this);
    }


}
