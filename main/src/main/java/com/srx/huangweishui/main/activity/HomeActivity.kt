package com.srx.huangweishui.main.activity

import android.support.v4.app.Fragment
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.srx.huangweishui.common.BaseActivity
import com.srx.huangweishui.common.R
import com.srx.huangweishui.common.utils.ActivityConstantPathJavaUtil
import com.srx.huangweishui.common.view.HomeTabView
import com.srx.huangweishui.main.adapter.TabAdapter
import com.srx.huangweishui.main.fragment.HomeFragment

/**
 * Created by huangweishui on 2018/9/26.
 */
@Route(path = ActivityConstantPathJavaUtil.HOMEACTIVITY)
class HomeActivity : BaseActivity(){
    lateinit var homeTabView:HomeTabView
    @Autowired
     var name:String = ""
    var listFragment= arrayListOf<Fragment>()
    var adapter:TabAdapter?=null
    override fun getContentView(): Int {
        return R.layout.activity_home
    }

    override fun initData() {
        super.initData()

    }
    override fun initView() {
        super.initView()
        homeTabView=findViewById(R.id.homeTabView) as HomeTabView
        listFragment.add(HomeFragment())
        listFragment.add(HomeFragment())
        listFragment.add(HomeFragment())
        listFragment.add(HomeFragment())
        adapter=TabAdapter(this,homeTabView.radiogroupMain,R.id.fl_content,listFragment,0)
    }
}