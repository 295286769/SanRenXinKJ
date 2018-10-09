package com.srx.huangweishui.common.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.srx.huangweishui.common.R

/**
 * Created by huangweishui on 2018/9/26.
 */
abstract class BaseFragment :Fragment(){
    open lateinit var mContext:Context;
    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mContext=getActivity()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initData()
    }

    open fun initData(){

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       var view:View?=getFragmentView();
        return view
    }
     abstract fun getFragmentView(): View?

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    open fun initView(): Unit {

    }
}