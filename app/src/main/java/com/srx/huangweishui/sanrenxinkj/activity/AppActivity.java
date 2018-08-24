package com.srx.huangweishui.sanrenxinkj.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.srx.huangweishui.common.BaseActivity;
import com.srx.huangweishui.common.WebActivity;
import com.srx.huangweishui.sanrenxinkj.R;
import com.srx.huangweishui.sanrenxinkj.model.MyAppBean;

/**
 * Created by huangweishui on 2018/8/23.
 */

public class AppActivity extends BaseActivity {
//    private ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//         mainBinding= DataBindingUtil.setContentView(this, R.layout.activity_main);
//        mainBinding.setMyAppBean(new MyAppBean("黄尚"));
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(1000);
                    Intent intent=new Intent(AppActivity.this, WebActivity.class);
                    startActivity(intent);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();
//        setContentView();
    }

    @Override
    public int setContentView() {
        return 0;
    }
}
