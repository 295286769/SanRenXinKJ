package com.srx.huangweishui.main.fragment

import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route
import com.srx.huangweishui.common.fragment.BaseFragment
import com.srx.huangweishui.common.utils.ActivityConstantPathUtil.Companion.HOMEFRAGMENT
import com.srx.huangweishui.main.R
import kotlinx.android.synthetic.main.fragment_home.*

/**
 * Created by huangweishui on 2018/9/26.
 */
@Route(path = HOMEFRAGMENT)
class HomeFragment : BaseFragment(){
    var viewHome: View?=null
    override fun getFragmentView(): View? {
        if(viewHome==null){
            viewHome=layoutInflater.inflate(R.layout.fragment_home,null)
        }
        return viewHome
    }

    override fun initView() {
        super.initView()
        baseTitleLayout.setTitle("首页")
        tv_content.setText("法大师傅士大夫士大夫")
//        tv_content.tv_content.setText("dfdsfs")
    }

}