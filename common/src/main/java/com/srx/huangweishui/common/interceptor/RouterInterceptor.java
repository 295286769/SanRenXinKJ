package com.srx.huangweishui.common.interceptor;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;
import com.srx.huangweishui.common.utils.ToasterManager;

/**
 * Created by huangweishui on 2018/8/27.
 */
@Interceptor(name = "测试拦截",priority = 8)
public class RouterInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
//        if(postcard.getPath().contains(ARouterPath.GirlsListAty)){
//
//            //自定义处理
//        }else {
//        }
        ToasterManager.showLongToast(postcard.getPath());
        callback.onContinue(postcard);  // 处理完成，交还控制权
        // callback.onInterrupt(new RuntimeException("我觉得有点异常"));   // 觉得有问题，中断路由流程
        // 以上两种至少需要调用其中一种，否则不会继续路由

    }

    @Override
    public void init(Context context) {
// 拦截器的初始化，会在sdk初始化的时候调用该方法，仅会调用一次
        ToasterManager.showLongToast("init");
    }
}
