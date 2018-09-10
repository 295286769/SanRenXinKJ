package com.srx.huangweishui.interceptor;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.srx.huangweishui.common.utils.Logger;

/**
 * Created by huangweishui on 2018/8/30.
 */
@Interceptor(priority = 3)
public class HomeIntercepter implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        Logger.i("TTT","extras+"+postcard.getExtra());
    }

    @Override
    public void init(Context context) {

    }
}
