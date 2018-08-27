//package com.srx.huangweishui.common;
//
//import android.databinding.BaseObservable;
//import android.databinding.DataBindingUtil;
//import android.databinding.ViewDataBinding;
//import android.os.Bundle;
//import android.support.annotation.Nullable;
//import android.support.v4.app.FragmentActivity;
//
//import com.srx.huangweishui.common.model.BaseViewModelImpl;
//
///**
// * Created by huangweishui on 2018/8/24.
// */
//
//public abstract class BaseDataBinDingActivity<V extends ViewDataBinding,VM extends BaseViewModelImpl> extends FragmentActivity {
//    private V binding;
//    private VM viewModel;
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(savedInstanceState);
//
//    }
//    private void setContentView(Bundle savedInstanceState) {
//        binding= DataBindingUtil.setContentView(this,getLayoutId(savedInstanceState));
//        binding.setVariable(setVariableId(),setViewModel());
//    }
//    public abstract int getLayoutId(Bundle savedInstanceState);
//    public abstract int setVariableId();
//    public abstract VM setViewModel();
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        viewModel = null;
//        binding.unbind();
//    }
//}
