package com.srx.huangweishui.common.aplication;

import android.app.Application;

/**
 * Created by huangweishui on 2018/8/23.
 */

public class BaseAplication extends Application {
    private static BaseAplication aplication;
    public static BaseAplication getIntence(){
        if(aplication==null){
            aplication=new BaseAplication();
        }
        return aplication;
    }
    @Override
    public void onCreate() {
        super.onCreate();
    }
}
