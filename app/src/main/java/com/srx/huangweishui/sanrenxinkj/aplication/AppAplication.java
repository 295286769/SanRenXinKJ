package com.srx.huangweishui.sanrenxinkj.aplication;

import com.alibaba.android.arouter.launcher.ARouter;
import com.srx.huangweishui.common.aplication.BaseAplication;

import static com.srx.huangweishui.sanrenxinkj.BuildConfig.isDebug;

/**
 * Created by huangweishui on 2018/8/23.
 */

public class AppAplication extends BaseAplication {
    @Override
    public void initData() {
        super.initData();
        if(isDebug){
            ARouter.openDebug();
            ARouter.openLog();
        }
        ARouter.init(this);
    }
}
