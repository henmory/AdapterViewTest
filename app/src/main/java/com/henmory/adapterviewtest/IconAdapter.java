package com.henmory.adapterviewtest;

import android.content.Context;

import java.util.List;

/**
 * Created by dan on 16/5/31.
 */
public class IconAdapter extends CommonAdapter<Icon> {

    public IconAdapter(List<Icon> mDatas, Context mContext, int mItemLayout) {
        super(mDatas, mContext, mItemLayout);
    }

    @Override
    public void convert(CommonViewHolder holder, Icon icon) {
        holder.setImageResource(R.id.image_view, icon.getIcon());
        holder.setText(R.id.tv_name, icon.getName());
    }
}
