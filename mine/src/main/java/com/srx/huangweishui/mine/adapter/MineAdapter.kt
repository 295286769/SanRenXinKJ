package com.srx.huangweishui.mine.adapter

import android.content.Context
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter
import com.srx.huangweishui.mine.holder.MineHolder
import com.srx.huangweishui.mine.R
import com.srx.huangweishui.mine.model.MinMultiItemEntity
import com.srx.huangweishui.mine.model.MinMultiItemEntity.Companion.HEAD
import com.srx.huangweishui.mine.model.MinMultiItemEntity.Companion.ITEM

class MineAdapter :BaseMultiItemQuickAdapter<MinMultiItemEntity, MineHolder>{


    constructor(context: Context):super(null){
        mContext=context
        addItemType(HEAD, R.layout.list_item)
        addItemType(ITEM, R.layout.list_item_content)

    }
    override fun convert(helper: MineHolder?, item: MinMultiItemEntity?) {
        when(item?.getItemType()){
            HEAD ->
                helper?.binData()
            ITEM ->
                helper?.binDataTwo()

        }
    }
}