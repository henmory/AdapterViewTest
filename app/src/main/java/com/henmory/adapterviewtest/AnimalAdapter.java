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
 * 没有任何优化的adapter
 *
 */
public class AnimalAdapter extends BaseAdapter {
    private List<Animal> animals;
    private Context context;

    public AnimalAdapter(List<Animal> animals, Context context) {
        this.animals = animals;
        this.context = context;
    }

    public void add(Animal animal) {
        if (animals == null) {
            animals = new ArrayList<>();
        }
        animals.add(animal);
        notifyDataSetChanged();
    }

    public void add(Animal animal, int position) {
        if (animals == null) {
            animals = new ArrayList<>();
        }
        animals.add(position, animal);
        notifyDataSetChanged();
    }

    public void delete(Animal animal) {
        if (animals != null) {
            animals.remove(animal);
        }
        notifyDataSetChanged();
    }

    public void delete(int position) {
        if (animals != null) {
            animals.remove(position);
        }
        notifyDataSetChanged();
    }

    public void monify(Animal animal, int position){
        Animal tmp = animals.get(position);
        if (tmp != null) {
            tmp.setDescription(animal.getDescription());
            tmp.setIcon(animal.getIcon());
            tmp.setName(animal.getName());
            notifyDataSetChanged();
        }
    }

    public void clear(){
        if (animals != null){
            animals.clear();
        }
        notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return animals.size();
    }

    @Override
    public Animal getItem(int position) {
        return animals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /*
    * 该函数是加载list单项的代码实现，list有多少项就加载多少次
    * 1.复用convertView
    * 2.重用viewHolder
    * */
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.listview_item, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.iv = (ImageView) convertView.findViewById(R.id.image_id);
            viewHolder.name = (TextView) convertView.findViewById(R.id.name_id);
            viewHolder.desc = (TextView) convertView.findViewById(R.id.desc_id);
            viewHolder.cb = (CheckBox) convertView.findViewById(R.id.cb);
            viewHolder.cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (viewHolder.cb.isChecked()) {
                        MainActivity.selected = position;
                    }else{
                        MainActivity.selected = -1;
                    }
                }
            });
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.iv.setBackgroundResource(animals.get(position).getIcon());
        viewHolder.desc.setText(animals.get(position).getDescription());
        viewHolder.name.setText(animals.get(position).getName());
        return convertView;
    }

    public static class ViewHolder {
        ImageView iv;
        TextView name;
        TextView desc;
        CheckBox cb;
    }
}
