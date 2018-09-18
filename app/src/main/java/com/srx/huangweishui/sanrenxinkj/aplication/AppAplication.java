package com.srx.huangweishui.sanrenxinkj.aplication;

import android.os.Debug;

import com.alibaba.android.arouter.launcher.ARouter;
import com.srx.huangweishui.common.aplication.BaseAplication;
import com.srx.huangweishui.common.utils.StartActivityJavaUtil;
import com.srx.huangweishui.sanrenxinkj.server.StartServer;

import static com.srx.huangweishui.sanrenxinkj.BuildConfig.isDebug;

/**
 * Created by huangweishui on 2018/8/23.
 */

public class AppAplication extends BaseAplication {
    @Override
    public void initData() {
        if(isDebug){
            Debug.startMethodTracing("myTracing");
        }
        super.initData();

        StartServer.Companion.startServer(this);
    }
}
