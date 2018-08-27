package com.srx.huangweishui.common.utils

import android.app.Activity
import com.alibaba.android.arouter.launcher.ARouter
import com.srx.huangweishui.common.utils.ActivityConstantPathUtil.Companion.STARTKOTLINACTIVITY


/**
 * Created by huangweishui on 2018/8/23.
 */
class StartActivityUtil {
    companion object{
        fun startWellComActivity( userName:String){

            ARouter.getInstance().build(STARTKOTLINACTIVITY).withString("name",userName).navigation()
        }
    }
}