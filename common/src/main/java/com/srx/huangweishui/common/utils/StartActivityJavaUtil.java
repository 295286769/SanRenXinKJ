package com.srx.huangweishui.common.utils;

import android.content.Context;
import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.callback.NavCallback;
import com.alibaba.android.arouter.facade.callback.NavigationCallback;
import com.alibaba.android.arouter.launcher.ARouter;
import com.srx.huangweishui.common.interceptor.RouterInterceptor;

import static com.srx.huangweishui.common.utils.ActivityConstantPathJavaUtil.ADDACTIVITY;
import static com.srx.huangweishui.common.utils.ActivityConstantPathJavaUtil.HOMEACTIVITY;
import static com.srx.huangweishui.common.utils.ActivityConstantPathJavaUtil.MAINACTIVITY;
import static com.srx.huangweishui.common.utils.ActivityConstantPathJavaUtil.MINEACTIVITY;
import static com.srx.huangweishui.common.utils.ActivityConstantPathJavaUtil.WELLCOMACTIVITY;
import static com.srx.huangweishui.common.utils.ActivityConstantPathUtil.HOMEFRAGMENT;
import static com.srx.huangweishui.common.utils.ActivityConstantPathUtil.MINEFRAGMENT;


/**
 * Created by huangweishui on 2018/8/27.
 */

public class StartActivityJavaUtil {
    //fragment
    public static Fragment startHomeFragment(String userName){
       return (Fragment) ARouter.getInstance().build(HOMEFRAGMENT).withString("name",userName).navigation();
    }
    public static Fragment startMineFragment(String userName){
       return (Fragment) ARouter.getInstance().build(MINEFRAGMENT).withString("name",userName).navigation();
    }

    //activity
    public static void startWellComActivity(String userName){

            ARouter.getInstance().build(WELLCOMACTIVITY).withString("name",userName).navigation();
    }
    public static void startHomeActivity(String userName){

            ARouter.getInstance().build(HOMEACTIVITY).withString("name",userName).navigation();
    }
    public static void startTestActivity(String userName){

            ARouter.getInstance().build(ActivityConstantPathJavaUtil.TESTACTIVITY).withString("name",userName).navigation();
    }
    public static void startWebActivity(String userName){

            ARouter.getInstance().build(ActivityConstantPathJavaUtil.WEBACTIVITY).withString("name",userName).navigation();
    }
    public static void startAddActivity(String userName){

            ARouter.getInstance().build(ADDACTIVITY).withString("name",userName).navigation();
    }
    public static void startMainActivity(Context context,String userName){

            ARouter.getInstance().build(MAINACTIVITY).withString("name",userName).navigation(context, new NavigationCallback() {
                @Override
                public void onFound(Postcard postcard) {
                    Logger.i("TTT","onFound+");
                }

                @Override
                public void onLost(Postcard postcard) {
                    Logger.i("TTT","onLost+");
                }

                @Override
                public void onArrival(Postcard postcard) {
                    Logger.i("TTT","onArrival+");
                }

                @Override
                public void onInterrupt(Postcard postcard) {
                    Logger.i("TTT","onInterrupt+");
                }
            });
    }
    public static void startMineActivity(Context context,String userName){

            ARouter.getInstance().build(MINEACTIVITY).withString("name",userName).navigation(context, new NavigationCallback() {
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
