package com.srx.huangweishui.sanrenxinkj.server

import android.app.IntentService
import android.content.Context
import android.content.Intent
import com.alibaba.android.arouter.launcher.ARouter
import com.srx.huangweishui.common.utils.Logger
import com.srx.huangweishui.sanrenxinkj.BuildConfig

/**
 * Created by huangweishui on 2018/9/18.
 */
class StartServer : IntentService {
    constructor():super("firstSever"){

    }
    companion object{
        val STARTSERVER:String="com.srx.huangweishui.sanrenxinkj.server.StartServer"
        fun startServer(context: Context): Unit {
            var intent=Intent(context,StartServer::class.java)
            intent.setAction(STARTSERVER)
            context.startService(intent)
        }
    }
    override fun onHandleIntent(intent: Intent?) {

        if(intent?.action.equals(STARTSERVER)){
            if (BuildConfig.DEBUG) {
                ARouter.openDebug()
                ARouter.openLog()
                Logger.i("TTT","DEBUG成功")
            }
            Logger.i("TTT","启动server成功"+this.application)
            ARouter.init(this.application)

        }

    }
}