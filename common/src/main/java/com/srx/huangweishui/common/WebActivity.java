package com.srx.huangweishui.common;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.srx.huangweishui.common.utils.ActivityConstantPathJavaUtil;

/**
 * Created by huangweishui on 2018/8/23.
 */
@Route(path = ActivityConstantPathJavaUtil.WEBACTIVITY)
public class WebActivity extends BaseActivity {
//    private ActivityWebBinding activityWebBinding;

//    @Override
//    public void setContentView() {
//        activityWebBinding=DataBindingUtil.setContentView(this,R.layout.activity_web);
//    }

    @Override
    public int getContentView() {
        return R.layout.activity_web;
    }
}
