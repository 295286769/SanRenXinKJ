package com.srx.huangweishui.common.utils;

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.srx.huangweishui.common.interceptor.RouterInterceptor;


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
    public static void startHomeActivity(String userName){

            ARouter.getInstance().build(ActivityConstantPathJavaUtil.HOMEACTIVITY).withString("name",userName).navigation();
    }
    public static void startMineActivity(Context context,String userName){

            ARouter.getInstance().build(ActivityConstantPathJavaUtil.MINEACTIVITY).withString("name",userName).navigation(context, new NavigationCallback() {
                @Override
                public void onArrival(Postcard postcard) {
                    Logger.i("TTT","onArrival+");
                }

                @Override
                public void onInterrupt(Postcard postcard) {
                    Logger.i("TTT","onInterrupt+");
                }

                @Override
                public void onFound(Postcard postcard) {
                    Logger.i("TTT","onFound+");
                }

                @Override
                public void onLost(Postcard postcard) {
                    Logger.i("TTT","onLost+");
                }
            });
    }
}
