package com.srx.huangweishui.mine;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.srx.huangweishui.common.BaseActivity;
import com.srx.huangweishui.common.utils.ActivityConstantPathJavaUtil;
import com.srx.huangweishui.common.utils.ImageLoderUtil;
import com.srx.huangweishui.common.utils.Logger;
import com.srx.huangweishui.mine.controller.MinController;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangweishui on 2018/8/27.
 */
@Route(path = ActivityConstantPathJavaUtil.MINEACTIVITY, extras = 1)
public class MineActivity extends BaseActivity {
    @Autowired
    String name;

    private TextView textView;
    private ImageView img_icon;
    private ImageView img_url;
    private MinController minController;

    @Override
    public int getContentView() {
        return R.layout.mine_activity;
    }

    @Override
    public void initData() {
        super.initData();
        minController=new MinController(this);
    }

    @Override
    public void initView() {
        super.initView();

        textView = (TextView) findViewById(R.id.tv_content);
        img_icon = (ImageView) findViewById(R.id.img_icon);
        img_url = (ImageView) findViewById(R.id.img_url);
        textView.setText(name);
        Logger.i("TTT", "name" + name);
        ImageLoderUtil.loadImage(R.drawable.icon_driver,img_icon);
        String url="http://avis-img.oss-cn-shanghai.aliyuncs.com/chauffeur/head/c79ab6a702ef981097fbbd0a869596f5.png?x-oss-process=image/resize,m_pad,h_330,w_390";
        ImageLoderUtil.loadCircleImage(url,img_url);


    }

    String gage ="";
    private List<Integer> integers = new ArrayList<>();

    @Override
    public void initRequest() {
        super.initRequest();
        minController.setMy();
        minController.setYours();
        integers.clear();
        for (int i = 0; i < 10; i++) {
//                new TestThread(i + "").start();

//            integers.add(gage);
//            synchronized (MineActivity.this) {
//                gage = i;
//                new Thread() {
//                    @Override
//                    public void run() {
//                        super.run();
//
//                        getAge();
//
//                    }
//                }.start();
//            }

        }

    }

    public synchronized void getAge() {
//        synchronized (integers){
        Logger.i("TTT", "Thread_1" + gage);

//        }

    }

    class TestThread extends Thread {
        private String position = "";

        TestThread(String position) {
            this.position = position;

        }

        @Override
        public void run() {
            super.run();
            synchronized (this){
                gage=position;
                Logger.i("TTT", "Thread_1" + gage);
            }
        }
    }
}
