package com.srx.huangweishui.common;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by huangweishui on 2018/8/21.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initData();
        initView();
        initRequest();
    }

    private void initRequest() {

    }

    private void initView() {
    }

    private void initData() {
    }
}
