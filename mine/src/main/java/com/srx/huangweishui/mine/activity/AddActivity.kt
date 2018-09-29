package com.srx.huangweishui.mine.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.srx.huangweishui.common.BaseActivity
import com.srx.huangweishui.common.utils.ActivityConstantPathJavaUtil.ADDACTIVITY
import com.srx.huangweishui.mine.R
@Route(path =ADDACTIVITY )
class AddActivity:BaseActivity() {
    override fun getContentView(): Int {
        return R.layout.activity_add
    }
}