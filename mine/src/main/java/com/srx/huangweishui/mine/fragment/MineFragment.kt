package com.srx.huangweishui.mine.fragment

import android.view.LayoutInflater
import android.view.View
import com.alibaba.android.arouter.facade.annotation.Route

import com.srx.huangweishui.common.fragment.BaseFragment
import com.srx.huangweishui.common.utils.ActivityConstantPathUtil.Companion.MINEFRAGMENT
import com.srx.huangweishui.mine.R
import com.srx.huangweishui.mine.adapter.MineAdapter
import com.srx.huangweishui.mine.model.MinBean
import com.srx.huangweishui.mine.model.MinMultiItemEntity
import kotlinx.android.synthetic.main.fragment_mine.*

@Route(path = MINEFRAGMENT)
class MineFragment : BaseFragment() {
  private var viewMine: View? = null
  private lateinit var adapter: MineAdapter;
  var listDatas = arrayListOf<MinMultiItemEntity>()
  override fun getFragmentView(): View? {
    if (viewMine == null) {
      viewMine = LayoutInflater.from(activity)
          .inflate(R.layout.fragment_mine, null)
    }
    return viewMine
  }

  override fun initData() {
    super.initData()
    adapter = MineAdapter(mContext)
  }

  override fun initView() {
    super.initView()
    for (i in 0..10) {
      var entity = MinMultiItemEntity()
      if (i % 2 == 0) {
        entity.setTypeInt(0)
      } else {
        entity.setTypeInt(1)
      }
      entity.setBeanInfo(MinBean("taish"))
      listDatas.add(entity)
    }
    freshLoadMoreView.setAdapter(adapter)
    adapter.setNewData(listDatas)
    freshLoadMoreView.setCanRefresh(false)
    freshLoadMoreView.setCanLoadMore(false)
  }
}
