package com.srx.huangweishui.common.controller

import android.content.Context
import java.util.concurrent.*

/**
 * Created by huangweishui on 2018/9/18.
 */
class ThreadTroller {
    private var context:Context?=null
    private lateinit var  excouter:ScheduledThreadPoolExecutor;
    constructor(context: Context){
        this.context=context;
    }
    init {
        excouter=ScheduledThreadPoolExecutor(3)
    }

    fun excut(): Unit {
        if(excouter!=null){
            excouter.scheduleWithFixedDelay(object :Runnable{
                override fun run() {

                }

            },1000,1000,TimeUnit.SECONDS)
        }

    }

    fun setClear(): Unit {
        if(excouter!=null){
            excouter.shutdown()
        }
    }

}