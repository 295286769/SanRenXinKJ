package com.srx.huangweishui.mine.fragment

import android.view.LayoutInflater
import android.view.View

import com.srx.huangweishui.common.fragment.BaseFragment
import com.srx.huangweishui.mine.R

class MineFragment : BaseFragment() {
    private var viewMine: View? = null
    override fun getFragmentView(): View? {
        if (viewMine == null) {
            viewMine = LayoutInflater.from(activity).inflate(R.layout.fragment_mine, null)
        }
        return viewMine
    }
}
