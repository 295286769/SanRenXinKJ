package com.srx.huangweishui.common;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.launcher.ARouter;

/**
 * Created by huangweishui on 2018/8/21.
 */

public abstract class BaseActivity extends FragmentActivity {
    public Context mContext;
    private boolean isInjectArouter=true;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setAppThem();
        super.onCreate(savedInstanceState);
        try {
            setContentView(getContentView());
        } catch (Exception e) {
            e.printStackTrace();
        }
        mContext=this;
        initIsInjectArouter();
        if(isInjectArouter){
            injectArouter();
        }
        initData();
        initView();
        initRequest();
    }

    protected  void setAppThem(){

    };

    protected  void initIsInjectArouter(){

    };

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

    public void setIsInjectArouter(boolean isInjectArouter) {
        this.isInjectArouter = isInjectArouter;
    }
}
