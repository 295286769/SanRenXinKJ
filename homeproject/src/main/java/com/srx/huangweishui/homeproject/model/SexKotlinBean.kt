package com.srx.huangweishui.homeproject.model

import android.databinding.BaseObservable
import android.databinding.Bindable
import com.srx.huangweishui.homeproject.BR


/**
 * Created by huangweishui on 2018/8/22.
 */
class SexKotlinBean : BaseObservable() {
    @Bindable
    var sexName:String=""
    get() = field
    set(value) {
        field=value
        notifyPropertyChanged(BR.sexName)
    }

}