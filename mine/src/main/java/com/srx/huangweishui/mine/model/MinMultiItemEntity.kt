package com.srx.huangweishui.mine.model

import com.chad.library.adapter.base.entity.MultiItemEntity

class MinMultiItemEntity:MultiItemEntity {
    companion object {
        const val HEAD:Int=0
        const val ITEM:Int=1
    }
    var type:Int=0
    var bean:Any?=null
    override fun getItemType(): Int {
        return type
    }

    fun setTypeInt(typep:Int): Unit {
        this.type=typep
    }
    fun setBeanInfo(bean:Any){
        this.bean=bean
    }
    fun getBeanInfo():Any?{
        return bean
    }
}