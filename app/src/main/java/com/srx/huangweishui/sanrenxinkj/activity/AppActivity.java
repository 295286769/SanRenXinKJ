package com.srx.huangweishui.sanrenxinkj.activity;

import com.srx.huangweishui.common.BaseActivity;
import com.srx.huangweishui.common.utils.StartActivityJavaUtil;
import com.srx.huangweishui.sanrenxinkj.R;

/**
 * Created by huangweishui on 2018/8/23.
 */

public class AppActivity extends BaseActivity {
//    private ActivityMainBinding activityMainBinding;
//
//
//    @Override
//    public void setContentView() {
//        activityMainBinding=DataBindingUtil.setContentView(this, R.layout.activity_main);
//    }

    @Override
    public int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void initView() {
        super.initView();
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(1000);
                    AppActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            StartActivityJavaUtil.startMineActivity("皇上");
                        }
                    });

//                    Intent intent=new Intent(AppActivity.this, WellComActivity.class);
//                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
