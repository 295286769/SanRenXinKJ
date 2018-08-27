package com.srx.huangweishui.homeproject.activity;



import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.srx.huangweishui.common.BaseActivity;
import com.srx.huangweishui.common.utils.ActivityConstantPathJavaUtil;
import com.srx.huangweishui.homeproject.R;


/**
 * Created by huangweishui on 2018/8/24.
 */
@Route(path = ActivityConstantPathJavaUtil.STARTKOTLINACTIVITY)
public class WellComActivity extends BaseActivity {
//private ActivityWellcomBinding activityWellcomBinding;
//    @Autowired
//     String name;

//    @Override
//    public void setContentView() {
//        activityWellcomBinding= DataBindingUtil.setContentView(this,R.layout.activity_wellcom);
//    }

    @Override
    public int getContentView() {
        return R.layout.activity_wellcom;
    }

    @Override
    public void initData() {
        super.initData();
//        activityWellcomBinding.tvContent.setText("欢迎光临");
    }
}
