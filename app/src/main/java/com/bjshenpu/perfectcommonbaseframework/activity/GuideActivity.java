package com.bjshenpu.perfectcommonbaseframework.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bjshenpu.perfectcommonbaseframework.R;
import com.bjshenpu.perfectcommonbaseframework.constant.ExtraName;
import com.bjshenpu.perfectcommonbaseframework.utils.DensityUtils;
import com.bjshenpu.perfectcommonbaseframework.utils.SpUtils;
import java.util.ArrayList;

/**
 * ============================================================
 * <p/>
 * 版 权 ：
 * <p/>
 * 作 者 : Quentin
 * <p/>
 * 版 本 ： 1.0
 * <p/>
 * 创建日期 ： 2015/12/1 22:20
 * <p/>
 * 描 述 ：向导页
 * <p/>
 * ============================================================
 **/
public class GuideActivity extends AppCompatActivity {

    private String TAG = "GuideActivity";

    /**
     * viewPager 欢迎页面
     */
    ViewPager vpGuideWelcome;
    /**
     * 开始体验按钮
     */
    Button btnGuideStartExperience;
    /**
     * 下方圆点组
     */
    LinearLayout llWelcomePointGroup;
    /**
     * 选择红点
     */
    View selectGuidePoint;

    /**
     * 圆点集合
     */
    private ArrayList<ImageView> imageViews;
    /**
     * 圆点组之间的距离
     */
    private float mPointGroupLeft;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initView();
        initData();
        setData();
    }

    private void setData() {

        MyPageAdapter myPageAdapter = new MyPageAdapter();
        vpGuideWelcome.setAdapter(myPageAdapter);


        MyOnPageChangeListener myOnPageChangeListener = new MyOnPageChangeListener();
        vpGuideWelcome.setOnPageChangeListener(myOnPageChangeListener);


        selectGuidePoint.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                //移除监听
                selectGuidePoint.getViewTreeObserver().removeGlobalOnLayoutListener(this);

                //获取圆点组之间的每个圆点的间距

                mPointGroupLeft = llWelcomePointGroup.getChildAt(1).getLeft() - llWelcomePointGroup.getChildAt(0).getLeft();

            }
        });



        btnGuideStartExperience.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //进入主页面
                startActivity(new Intent(GuideActivity.this, MainActivity.class));
                SpUtils.saveBoolean(ExtraName.FIRST_ENTERED, true);
                GuideActivity.this.finish();
            }
        });
    }

    /**
     * 初始化view
     */
    private void initView() {

        vpGuideWelcome= (ViewPager) findViewById(R.id.vp_guide_welcome);
        btnGuideStartExperience= (Button) findViewById(R.id.btn_guide_start_experience);
        llWelcomePointGroup= (LinearLayout) findViewById(R.id.ll_welcome_point_group);
        selectGuidePoint= findViewById(R.id.select_guide_point);



    }

    /**
     * 初始化数据
     */
    private void initData() {

        imageViews = new ArrayList<>();

        int[] imageResIDs = {
                R.mipmap.guide_1,
                R.mipmap.guide_2,
                R.mipmap.guide_3
        };


        //添加图片
        ImageView imageView;
        //添加圆点
        View v;

        for (int i = 0; i < imageResIDs.length; i++) {

            imageView = new ImageView(this);
            imageView.setBackgroundResource(imageResIDs[i]);

            imageViews.add(imageView);


            //添加到集合当中
            v=new View(this);
            v.setBackgroundResource(R.drawable.point_normal);

            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(DensityUtils.dp2px(this, 10),
                    DensityUtils.dp2px(this,10));
            //不是第一个才设置边距
            if(i != 0 )
            {
                layoutParams.leftMargin= DensityUtils.dp2px(this,10);
            }

            v.setLayoutParams(layoutParams);
            llWelcomePointGroup.addView(v);
        }

    }



    private class MyOnPageChangeListener implements ViewPager.OnPageChangeListener
    {
        /**
         * 当页面正在滑动中时触发此方法.
         * @param position  当前滑动的是第几页
         * @param positionOffset        滑动的偏移量,百分比
         * @param positionOffsetPixels   滑动的像素
         */
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            float leftMargin = mPointGroupLeft*(position+positionOffset);

            RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) selectGuidePoint.getLayoutParams();
            lp.leftMargin = (int) leftMargin;
            selectGuidePoint.setLayoutParams(lp);

        }

        /**
         * 当新的页面被选中时触发.
         * @param position
         */
        @Override
        public void onPageSelected(int position) {
            //如果当前被选中页面是最后一页,显示立即登录
            if(position == imageViews.size() -1 )
            {
                btnGuideStartExperience.setVisibility(View.VISIBLE);
            }
        }

        /**
         *  当页面滚动状态改变时.
         * @param state
         */
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }


    /**
     * viewPager适配器
     */
    private class MyPageAdapter extends PagerAdapter
    {
        @Override
        public int getCount() {
            return imageViews.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view==object;
        }


        /**
         * container 就是ViewPager
         * object 就是当前需要被移除的View
         */
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // 把ImageView添加到ViewPager中, 并且把ImageView返回回去.
            ImageView imageView = imageViews.get(position);
            container.addView(imageView);
            return imageView;
        }
    }

}
