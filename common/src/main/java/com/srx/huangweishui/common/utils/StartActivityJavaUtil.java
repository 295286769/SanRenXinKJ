package com.srx.huangweishui.common.utils;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
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
    public static void startMineActivity(Context context,String userName){

            ARouter.getInstance().build(ActivityConstantPathJavaUtil.MINEACTIVITY).withString("name",userName).navigation(context, new NavCallback() {
                @Override
                public void onArrival(Postcard postcard) {

                }

                @Override
                public void onInterrupt(Postcard postcard) {
                }

                @Override
                public void onFound(Postcard postcard) {
                }

                @Override
                public void onLost(Postcard postcard) {
                }
            });
    }
}
