package com.henmory.adapterviewtest;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dan on 16/5/26.
 * 使用抽象出来的viewHolder
 */
public class AnimalAdapterWithCommonViewHolder extends BaseAdapter {
    private List<Animal> animals;
    private Context context;

    public AnimalAdapterWithCommonViewHolder(List<Animal> animals, Context context) {
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


    @Override
    public View getView( int position, View convertView, ViewGroup parent) {

        CommonViewHolder holder = CommonViewHolder.getViewHolder(context,convertView, parent, R.layout.listview_item, position);

        ((TextView)holder.getView(R.id.name_id)).setText(animals.get(position).getName());
        ((TextView)holder.getView(R.id.desc_id)).setText(animals.get(position).getDescription());
        ((ImageView)holder.getView(R.id.image_id)).setImageResource(animals.get(position).getIcon());

        return holder.getConvertView();
    }

}
