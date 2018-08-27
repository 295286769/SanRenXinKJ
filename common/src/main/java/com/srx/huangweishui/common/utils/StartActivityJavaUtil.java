package com.srx.huangweishui.common.utils;

import com.alibaba.android.arouter.launcher.ARouter;


/**
 * Created by huangweishui on 2018/8/27.
 */

public class StartActivityJavaUtil {
    public static void startWellComActivity(String userName){

            ARouter.getInstance().build(ActivityConstantPathJavaUtil.STARTKOTLINACTIVITY).withString("name",userName).navigation();
    }
    public static void startTestActivity(String userName){

            ARouter.getInstance().build(ActivityConstantPathJavaUtil.TESTACTIVITY).withString("name",userName).navigation();
    }
    public static void startWebActivity(String userName){

            ARouter.getInstance().build(ActivityConstantPathJavaUtil.WEBACTIVITY).withString("name",userName).navigation();
    }
    public static void startMineActivity(String userName){

            ARouter.getInstance().build(ActivityConstantPathJavaUtil.WEBACTIVITY).withString("name",userName).navigation();
    }
}
