package com.srx.huangweishui.common.model;

import android.content.Context;

import com.srx.huangweishui.common.inteface.BaseViewModel;

/**
 * Created by huangweishui on 2018/8/24.
 */

public class BaseViewModelImpl  implements BaseViewModel {
    public Context mContext;
    public BaseViewModelImpl(Context context){
        mContext=context;
    }
}
