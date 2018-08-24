package com.srx.huangweishui.homeproject.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.srx.huangweishui.common.inteface.BaseViewModel;
import com.srx.huangweishui.common.model.BaseViewModelImpl;
import com.srx.huangweishui.homeproject.BR;

/**
 * Created by huangweishui on 2018/8/24.
 */

public class WellComBean extends BaseViewModelImpl{
    private String title;

    public WellComBean(String title) {
        this.title = title;

    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }
}
