package com.srx.huangweishui.homeproject.activity;

import android.app.Activity;
import android.databinding.DataBindingUtil;
import android.os.Bundle;

import com.srx.huangweishui.homeproject.R;
import com.srx.huangweishui.homeproject.databinding.ActivityHomeBinding;

/**
 * Created by huangweishui on 2018/8/24.
 */

public class HomeActivity extends Activity {
    private ActivityHomeBinding activityHomeBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityHomeBinding= DataBindingUtil.setContentView(this,setContentView());
    }

    public int setContentView() {
        return R.layout.activity_home;
    }
}
