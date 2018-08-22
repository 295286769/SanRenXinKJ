package com.srx.huangweishui.homeproject.model;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.srx.huangweishui.homeproject.BR;

/**
 * Created by huangweishui on 2018/8/21.
 */

public class SexBean extends BaseObservable {
    private String name;

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
}
