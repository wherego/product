package com.bjshenpu.perfectcommonbaseframework.adapter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.bjshenpu.perfectcommonbaseframework.R;
import com.bjshenpu.perfectcommonbaseframework.model.Ad;
import com.bjshenpu.perfectcommonbaseframework.utils.Test;
import com.bumptech.glide.Glide;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import java.util.List;
public class BannerAdapter extends StaticPagerAdapter {

    private Context ctx;
    private List<Ad> list;
       public BannerAdapter(Context ctx){
           this.ctx = ctx;
            list = Test.getAdList();
        }

        @Override
        public View getView(ViewGroup container, final int position) {
            ImageView imageView = new ImageView(ctx);
            imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            //加载图片
            Glide.with(ctx)
                    .load(list.get(position).getImage())
                    .placeholder(R.mipmap.default_image)
                    .into(imageView);
            //点击事件
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    ctx.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(list.get(position).getUrl())));
                }
            });
            return imageView;
        }

        @Override
        public int getCount() {
            return list.size();
        }
    }