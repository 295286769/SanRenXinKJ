package com.srx.huangweishui.sanrenxinkj.activity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.srx.huangweishui.common.BaseActivity;
import com.srx.huangweishui.common.utils.ActivityConstantPathJavaUtil;
import com.srx.huangweishui.sanrenxinkj.R;

/**
 * Created by huangweishui on 2018/8/27.
 */
@Route(path = ActivityConstantPathJavaUtil.TESTACTIVITY)
public class TestActivity extends BaseActivity {
    @Override
    public int getContentView() {
        return R.layout.test_activity;
    }
}
