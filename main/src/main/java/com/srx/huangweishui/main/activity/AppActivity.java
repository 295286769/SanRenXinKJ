package com.srx.huangweishui.main.activity;

import android.os.Bundle;
import android.os.Debug;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;

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
                            StartActivityJavaUtil.startMainActivity(AppActivity.this,"黄尚");
                            finish();
                        }
                    });

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }

}
