package com.srx.huangweishui.mine;

import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.srx.huangweishui.common.BaseActivity;
import com.srx.huangweishui.common.utils.ActivityConstantPathJavaUtil;
import com.srx.huangweishui.common.utils.Logger;

/**
 * Created by huangweishui on 2018/8/27.
 */
@Route(path = ActivityConstantPathJavaUtil.MINEACTIVITY,extras = 1)
public class MineActivity extends BaseActivity {
    @Autowired
    String name;

    private TextView textView;
    @Override
    public int getContentView() {
        return R.layout.mine_activity;
    }

    @Override
    public void initView() {
        super.initView();

        textView=(TextView)findViewById(R.id.tv_content) ;
        textView.setText(name);
        Logger.i("TTT","name"+name);


    }
}
