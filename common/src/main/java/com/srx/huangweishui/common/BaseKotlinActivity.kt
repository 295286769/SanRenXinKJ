package com.srx.huangweishui.common

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.srx.huangweishui.common.aplication.BaseKotlinAplication

/**
 * Created by huangweishui on 2018/8/21.
 */
open abstract class BaseKotlinActivity:AppCompatActivity() {
    public var mContext:Context?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        mContext=this
        initData()
        initView()
        initRequest()

    }
    abstract fun getLayoutId():Int
    open fun initData() {
    }
    open fun initView() {
    }
    open fun initRequest() {
    }




    open fun showToast(message:String){

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}