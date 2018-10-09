package com.srx.huangweishui.main.activity

import android.support.v4.app.Fragment
import android.view.KeyEvent
import android.widget.RadioGroup
import com.alibaba.android.arouter.facade.annotation.Autowired
import com.alibaba.android.arouter.facade.annotation.Route
import com.srx.huangweishui.common.BaseActivity
import com.srx.huangweishui.common.adapter.TabAdapter
import com.srx.huangweishui.common.utils.ActivityConstantPathJavaUtil.MAINACTIVITY
import com.srx.huangweishui.common.utils.ListUtils
import com.srx.huangweishui.common.utils.StartActivityJavaUtil
import com.srx.huangweishui.common.utils.ToasterManager
import com.srx.huangweishui.main.R
import kotlinx.android.synthetic.main.activity_main_layout.*

@Route(path = MAINACTIVITY)
class MainActivity : BaseActivity() {
  @Autowired
  @JvmField var name: String = ""
  private var firstTime: Long = 0
  var adapter: TabAdapter? = null
  var fragments = arrayListOf<Fragment>()
  override fun getContentView(): Int {
    return R.layout.activity_main_layout
  }

  override fun initView() {
    super.initView()
    if (!ListUtils.isEmpty(fragments)) {
      fragments.clear()
    }
    fragments.add(StartActivityJavaUtil.startHomeFragment("首页"))
    fragments.add(StartActivityJavaUtil.startHomeFragment("第二页"))
    fragments.add(StartActivityJavaUtil.startHomeFragment("第三页"))
    fragments.add(StartActivityJavaUtil.startMineFragment("我的"))
    homeTabView_main
    adapter = TabAdapter(this, homeTabView_main?.radiogroupMain, R.id.fl_content_main, fragments, 0)
    adapter?.setTachangeListener(object : TabAdapter.OnTabChangeListener {
      override fun onTabChange(
        group: RadioGroup?,
        checkedId: Int,
        fragment: Fragment?,
        index: Int
      ) {
        homeTabView_main?.startLineAnimation(index)
      }

    })
  }

  override fun onKeyDown(
    keyCode: Int,
    event: KeyEvent?
  ): Boolean {
    val secondTime = System.currentTimeMillis()
    when (keyCode) {
      KeyEvent.KEYCODE_BACK -> {
        val secondTime = System.currentTimeMillis()
        if (secondTime - firstTime > 2000) {
          ToasterManager.showToast("再按一次退出程序")
          firstTime = secondTime
          return true
        } else {
          finish()
        }
      }
    }
    return super.onKeyDown(keyCode, event)
  }
}