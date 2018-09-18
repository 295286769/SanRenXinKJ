package com.srx.huangweishui.common.config

import android.content.Context
import android.os.Handler
import android.os.Message

/**
 * Created by huangweishui on 2018/9/13.
 */
class HandlerController {
    private var handler:Handler=object :Handler(){
        override fun handleMessage(msg: Message?) {
            super.handleMessage(msg)
        }
    };
    private var mContext:Context?=null
    constructor(context: Context){
        mContext=context
    }

    fun post(): Unit {

            handler?.post(object :Runnable{
                override fun run() {
                    var message:Message=Message.obtain()
                    handler?.sendMessage(message)
                }
            })

    }
   fun senMessage(){
       var message:Message=Message.obtain()
       handler?.sendMessage(message)
   }

    fun clearHandler(): Unit {
            handler?.removeCallbacksAndMessages(null)
    }
}