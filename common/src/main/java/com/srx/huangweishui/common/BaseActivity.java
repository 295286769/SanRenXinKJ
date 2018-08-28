package com.srx.huangweishui.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by huangweishui on 2018/8/21.
 */

public abstract class BaseActivity extends AppCompatActivity {
    public Context mContext;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        mContext=this;
        injectArouter();
        initData();
        initView();
        initRequest();
    }

    public abstract int getContentView();
    private void injectArouter(){
        ARouter.getInstance().inject(this);
    };

    public void initRequest() {

    }

    public void initView() {
    }

    public void initData() {
    }
}
