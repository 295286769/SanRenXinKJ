package com.srx.huangweishui.main.activity;



import com.alibaba.android.arouter.facade.annotation.Route;
import com.srx.huangweishui.common.BaseActivity;
import com.srx.huangweishui.main.R;

import static com.srx.huangweishui.common.utils.ActivityConstantPathJavaUtil.WELLCOMACTIVITY;

/**
 * Created by huangweishui on 2018/8/24.
 */
@Route(path = WELLCOMACTIVITY)
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
