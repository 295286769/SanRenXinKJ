package com.srx.huangweishui.main.fragment

import android.view.View
import com.srx.huangweishui.common.fragment.BaseFragment
import com.srx.huangweishui.main.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*

/**
 * Created by huangweishui on 2018/9/26.
 */
class HomeFragment : BaseFragment(){
    var viewHome: View?=null
    override fun getView(drawableId: Int): View? {
        if(viewHome==null){
            viewHome=layoutInflater.inflate(R.layout.fragment_home,null)
        }
        return viewHome
    }

    override fun initView() {
        super.initView()
        tv_content.tv_content.setText("dfdsfs")
    }

}