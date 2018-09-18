package com.srx.huangweishui.common.config

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import com.srx.huangweishui.common.inteface.ChangeUi
import com.srx.huangweishui.common.utils.ToasterManager

/**
 * Created by huangweishui on 2018/9/13.
 */
class LooperThread : Thread {

    private var mContext: Activity? = null
      private var changeUi: ChangeUi<String>?=null
    private var handler: Handler? = null
    private var map = hashMapOf<String, String>()
    private var list = arrayListOf<String>()

    constructor(context: Activity) {
        mContext = context;

    }

    constructor(runnable: Runnable) : super(runnable) {

    }
    init {
        map.put("n", "dsds")
        for ((key, value) in map) {
            ToasterManager.showLongToast(value);
        }
        var name: String = map["n"] as String
        ToasterManager.showLongToast(name);
        a@ for (i in list.indices) {
            break@a
        }
        var names= arrayOf("a",2)
    }


    override fun run() {
        super.run()
        Looper.prepare()
        var childLooper: Looper = Looper.myLooper();//获取当前线程的Looper对象
        handler = object : Handler(childLooper) {
            override fun handleMessage(msg: Message?) {
                super.handleMessage(msg)
                var name = msg?.obj?.toString()
                mContext?.runOnUiThread(object : Runnable {
                    override fun run() {

                        try {
                            changeUi?.changeUi(name)
                        } catch(e: Exception) {
                        }
                    }

                })

            }
        }

        var message: Message? = handler?.obtainMessage()
        message?.what=10
        message?.obj = "我是黄尚"

        handler?.sendMessageDelayed(message, 200)
        Looper.loop()


    }


    fun setChangeUi(changeUi: ChangeUi<String>): Unit {
        this.changeUi = changeUi

    }

}