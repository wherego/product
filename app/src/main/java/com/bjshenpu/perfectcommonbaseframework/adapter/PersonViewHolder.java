package com.bjshenpu.perfectcommonbaseframework.adapter;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bjshenpu.perfectcommonbaseframework.R;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by Mr.Jude on 2015/2/22.
 */
public class PersonViewHolder extends BaseViewHolder<String> {
    private TextView mTv_name;


    public PersonViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_person);
        mTv_name = $(R.id.tv);
    }

    @Override
    public void setData(final String str){
        mTv_name.setText(str);
    }
}
