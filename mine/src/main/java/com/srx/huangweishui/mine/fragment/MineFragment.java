package com.srx.huangweishui.mine.fragment;

import android.view.LayoutInflater;
import android.view.View;

import com.srx.huangweishui.common.fragment.BaseFragment;
import com.srx.huangweishui.mine.R;

import org.jetbrains.annotations.Nullable;

public class MineFragment extends BaseFragment {
    private View viewMine;
    @Nullable
    @Override
    public View getFragmentView() {
        if(viewMine==null){
            viewMine=LayoutInflater.from(getActivity()).inflate(R.layout.fragment_mine,null);
        }
        return viewMine;
    }
}
