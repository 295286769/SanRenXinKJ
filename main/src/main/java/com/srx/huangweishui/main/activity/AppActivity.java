package com.srx.huangweishui.main.activity;

import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.srx.huangweishui.common.utils.StartActivityJavaUtil;

/**
 * Created by huangweishui on 2018/8/23.
 */

public class AppActivity extends AppCompatActivity {
//    private ActivityMainBinding activityMainBinding;
//
//
//    @Override
//    public void setContentView() {
//        activityMainBinding=DataBindingUtil.setContentView(this, R.layout.activity_main);
//    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Debug.stopMethodTracing();
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(1000);
                    AppActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            StartActivityJavaUtil.startHomeActivity("黄尚");
                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

//    @Override
//    public void initData() {
//        super.initData();
//
//    }
//
//    @Override
//    public int getContentView() {
////        return R.layout.activity_main;
//        return 0;
//    }
//
//    @Override
//    public void initView() {
//        super.initView();
//        new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                try {
//                    Thread.sleep(1000);
//                    AppActivity.this.runOnUiThread(new Runnable() {
//                        @Override
//                        public void run() {
//                            StartActivityJavaUtil.startMineActivity(mContext,"皇上");
//                        }
//                    });
//
////                    Intent intent=new Intent(AppActivity.this, WellComActivity.class);
////                    startActivity(intent);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();
//    }
}
