package com.srx.huangweishui.common.aplication

import android.app.Application

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
        initData()
    }

    open fun initData() {
    }
}