package com.srx.huangweishui.homeproject.activity;

import android.os.Bundle;

import com.srx.huangweishui.common.BaseDataBinDingActivity;
import com.srx.huangweishui.homeproject.BR;
import com.srx.huangweishui.homeproject.R;
import com.srx.huangweishui.homeproject.databinding.ActivityWellcomBinding;
import com.srx.huangweishui.homeproject.model.WellComBean;

/**
 * Created by huangweishui on 2018/8/24.
 */

public class WellComActivity extends BaseDataBinDingActivity<ActivityWellcomBinding,WellComBean> {

    @Override
    public int getLayoutId(Bundle savedInstanceState) {
        return R.layout.activity_wellcom;
    }

    @Override
    public int setVariableId() {
        return BR.wellComBean;
    }

    @Override
    public WellComBean setViewModel() {
        return new WellComBean("欢迎");
    }
}
