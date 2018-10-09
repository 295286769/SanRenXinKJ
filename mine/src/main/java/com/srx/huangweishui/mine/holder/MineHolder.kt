package com.srx.huangweishui.mine.holder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.chad.library.adapter.base.BaseViewHolder
import com.srx.huangweishui.common.utils.ImageLoderUtil
import com.srx.huangweishui.mine.R

class MineHolder : BaseViewHolder {
  //第一种布局
  var tv_mine_item: TextView? = null
  var imgListItem: ImageView? = null
  //第二种布局
  var tv_mine_two_item: TextView? = null

  constructor(view: View) : super(view) {
    tv_mine_item = (view).findViewById(R.id.tv_mine_item)
    tv_mine_two_item = (view).findViewById(R.id.tv_mine_two_item)
    imgListItem = (view).findViewById(R.id.imgListItem)

  }

  /**
   *
   */
  fun binData(): Unit {
    tv_mine_item?.setText("第一个")
    ImageLoderUtil.loadImage("https://avis-img.oss-cn-shanghai.aliyuncs.com/cms/coupon/22fb4abbbc62522516fe09427d5bfda5.jpeg",imgListItem)
  }

  /**
   *
   */
  fun binDataTwo(): Unit {
    tv_mine_two_item?.setText("第二个")
  }

}