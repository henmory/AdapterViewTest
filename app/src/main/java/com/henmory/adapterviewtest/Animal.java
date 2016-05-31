package com.henmory.adapterviewtest;

/**
 * Created by dan on 16/5/26.
 * 实体bean类
 * http://www.imooc.com/learn/372 这个网站有很好的视频供观看
 */
public class Animal {
    private String name;
    private String description;
    private int icon;
    private boolean isCheck;

    public Animal() {
    }

    public Animal(String name, String description, int icon) {
        this.name = name;
        this.description = description;
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
    public boolean getCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
