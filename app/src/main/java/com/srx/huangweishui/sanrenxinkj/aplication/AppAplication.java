package com.srx.huangweishui.sanrenxinkj.aplication;

import android.os.Debug;

import com.alibaba.android.arouter.launcher.ARouter;
import com.srx.huangweishui.common.aplication.BaseAplication;
import com.srx.huangweishui.sanrenxinkj.BuildConfig;

/**
 * Created by huangweishui on 2018/8/23.
 */

public class AppAplication extends BaseAplication {
  @Override
  public void initData() {
    if (BuildConfig.isDebug) {
      Debug.startMethodTracing("myTracing");
    }
    super.initData();
    if (BuildConfig.DEBUG) {
      ARouter.openDebug();
      ARouter.openLog();
    }
    ARouter.init(BaseAplication.getIntence());
    //        StartServer.Companion.startServer(BaseAplication.getIntence());
  }
}
