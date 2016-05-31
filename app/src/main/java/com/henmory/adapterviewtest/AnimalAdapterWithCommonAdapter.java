package com.henmory.adapterviewtest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dan on 16/5/26.
 * 注释部分是使用抽象出来的adpter
 * 后面又改进了一些viewHolder，使控件在设置值的时候也方便
 */
public class AnimalAdapterWithCommonAdapter extends CommonAdapter<Animal> {

    public AnimalAdapterWithCommonAdapter(List<Animal> datas, Context context, int mItemLayout) {
        super(datas, context, mItemLayout);
    }

    /*
    * 没有把它抽象到commonAdapter中，因为不同的数据类型修改细节不一样
    * ，但是也没有做成抽象方法，因为不一定所有数据都会修改
    * */
    public void monify(Animal animal, int position){
        Animal tmp = (Animal) mDatas.get(position);
        if (tmp != null) {
            tmp.setDescription(animal.getDescription());
            tmp.setIcon(animal.getIcon());
            tmp.setName(animal.getName());
            notifyDataSetChanged();
        }
    }

    public void clear(){
        if (mDatas != null){
            mDatas.clear();
        }
        notifyDataSetChanged();
    }

    @Override
    public void convert(CommonViewHolder holder, final Animal animal) {
        holder.setText(R.id.name_id, animal.getName());
        holder.setText(R.id.desc_id, animal.getDescription());
        holder.setImageResource(R.id.image_id, animal.getIcon());
        final CheckBox cb = (CheckBox) holder.getView(R.id.cb);
        cb.setChecked(animal.getCheck());
        holder.setOnClickListener(R.id.cb, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animal.setCheck(cb.isChecked());
            }
        });
//        ((TextView)holder.getView(R.id.name_id)).setText(animal.getName());
//        ((TextView)holder.getView(R.id.desc_id)).setText(animal.getDescription());
//        ((ImageView)holder.getView(R.id.image_id)).setImageResource(animal.getIcon());
    }
}
