package com.srx.huangweishui.homeproject.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.srx.huangweishui.common.BaseActivity
import com.srx.huangweishui.common.utils.ActivityConstantPathJavaUtil.HOMEACTIVITY
import com.srx.huangweishui.homeproject.R
@Route(path = HOMEACTIVITY)
class HomeActivity:BaseActivity() {
    override fun getContentView(): Int {
        return R.layout.activity_home
    }
}