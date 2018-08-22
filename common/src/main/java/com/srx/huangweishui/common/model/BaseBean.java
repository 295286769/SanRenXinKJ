package com.srx.huangweishui.common.model;


import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.srx.huangweishui.common.BR;

/**
 * Created by huangweishui on 2018/8/21.
 */

public class BaseBean extends BaseObservable {
    private String userName;

    @Bindable
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
        notifyPropertyChanged(BR.userName);
    }
}
