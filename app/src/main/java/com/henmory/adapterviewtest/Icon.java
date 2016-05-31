package com.henmory.adapterviewtest;

import android.widget.ImageView;

/**
 * Created by dan on 16/5/31.
 */
public class Icon {
    private int icon;
    private String name;

    public Icon(int icon, String name) {
        this.icon = icon;
        this.name = name;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
