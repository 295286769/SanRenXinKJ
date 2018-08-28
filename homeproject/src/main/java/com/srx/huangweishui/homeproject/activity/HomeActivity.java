package com.srx.huangweishui.homeproject.activity;


import com.alibaba.android.arouter.facade.annotation.Route;
import com.srx.huangweishui.common.BaseActivity;
import com.srx.huangweishui.homeproject.R;

import static com.srx.huangweishui.common.utils.ActivityConstantPathUtil.HOMEACTIVITY;


/**
 * Created by huangweishui on 2018/8/24.
 */
@Route(path =HOMEACTIVITY )
public class HomeActivity extends BaseActivity {
//    private Activit activityHomeBinding;
//    @Override
//    public void setContentView() {
////        activityHomeBinding= DataBindingUtil.setContentView(this,R.layout.activity_home);
//    }

    @Override
    public int getContentView() {
        return R.layout.activity_home;
    }
}
