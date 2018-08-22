package com.srx.huangweishui.homeproject.activity

import com.srx.huangweishui.common.BaseKotlinActivity
import com.srx.huangweishui.homeproject.R

/**
 * Created by huangweishui on 2018/8/22.
 */
class StartKotlinActivity: BaseKotlinActivity() {
    override fun getLayoutId(): Int {
        return R.layout.activity_start_kotlin
    }

    override fun initRequest() {
        super.initRequest()
        Thread(){
            kotlin.run {
                Thread.sleep(1000)

            }
        }.start()
    }
}