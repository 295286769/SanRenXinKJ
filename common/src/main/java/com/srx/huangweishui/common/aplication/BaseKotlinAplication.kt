package com.srx.huangweishui.common.aplication

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter
import com.srx.huangweishui.common.BuildConfig

/**
 * Created by huangweishui on 2018/8/21.
 */
open class BaseKotlinAplication :Application() {
    companion object{
        var mApplication:Application?=null
        fun getIncetence():Application?{
            if(mApplication==null){
                mApplication= BaseKotlinAplication()
            }
            return mApplication
        }
    }
    override fun onCreate() {
        super.onCreate()
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init( this ); // 尽可能早，推荐在Application中初始化
        initData()
    }

    open fun initData() {
    }
}