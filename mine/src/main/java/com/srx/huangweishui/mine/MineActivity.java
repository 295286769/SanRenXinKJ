package com.srx.huangweishui.mine;

import android.support.v4.app.Fragment;
import android.view.View;
import android.view.ViewStub;
import android.webkit.WebChromeClient;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.srx.huangweishui.common.BaseActivity;
import com.srx.huangweishui.common.adapter.TabAdapter;
import com.srx.huangweishui.common.aplication.BaseAplication;
import com.srx.huangweishui.common.config.GenericController;
import com.srx.huangweishui.common.config.LooperThread;
import com.srx.huangweishui.common.controller.ThreadTroller;
import com.srx.huangweishui.common.inteface.ChangeUi;
import com.srx.huangweishui.common.inteface.ObjectCallBack;
import com.srx.huangweishui.common.model.JavaScriptObject;
import com.srx.huangweishui.common.utils.ActivityConstantPathJavaUtil;
import com.srx.huangweishui.common.utils.ImageLoderUtil;
import com.srx.huangweishui.common.utils.Logger;
import com.srx.huangweishui.common.utils.NetworkUtils;
import com.srx.huangweishui.common.view.BaseTitleLayout;
import com.srx.huangweishui.common.view.BaseWebViewLayout;
import com.srx.huangweishui.common.view.HomeTabView;
import com.srx.huangweishui.common.wiget.BaseWebViewClient;
import com.srx.huangweishui.mine.controller.MinController;
import com.srx.huangweishui.mine.fragment.MineFragment;

import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangweishui on 2018/8/27.
 */
@Route(path = ActivityConstantPathJavaUtil.MINEACTIVITY, extras = 1)
public  class MineActivity extends BaseActivity implements View.OnClickListener,ChangeUi<String>{
//    @Autowired
//    String name;
    private HomeTabView homeTabViewMine;
    private TabAdapter tabAdapter;
    private List<Fragment> fragments;
//private BaseTitleLayout baseTitleLayout;
//    private TextView textView;
//    private ImageView img_icon;
//    private ImageView img_url;
//    private ViewStub viewStub;
//    private BaseWebViewLayout baseWebViewLayout;
//    private View view_data;
//    private MinController minController;
//    private LooperThread looperThread;
//    private ThreadTroller threadTroller;

    private volatile int total=0;

    @Override
    public int getContentView() {
        return R.layout.mine_activity;
    }

    @Override
    public void initData() {
        super.initData();
        fragments=new ArrayList<>();
        fragments.add(new MineFragment());
        fragments.add(new MineFragment());
        fragments.add(new MineFragment());
        fragments.add(new MineFragment());
//        minController = new MinController(this);
//        looperThread=new LooperThread(this);
//        threadTroller=new ThreadTroller(this);
    }

    @Override
    public void initView() {
        super.initView();
        homeTabViewMine=(HomeTabView)findViewById(R.id.homeTabView_mine);
        tabAdapter=new TabAdapter(this,homeTabViewMine.getRadiogroupMain(),R.id.fl_content_mine,fragments,0);
        tabAdapter.setTachangeListener(new TabAdapter.OnTabChangeListener() {
            @Override
            public void onTabChange(RadioGroup group, int checkedId, Fragment fragment, int index) {
                homeTabViewMine.startLineAnimation(index);
            }
        });
//        baseTitleLayout = (BaseTitleLayout) findViewById(R.id.baseTitleLayout);
//        textView = (TextView) findViewById(R.id.tv_content);
//        img_icon = (ImageView) findViewById(R.id.img_icon);
//        img_url = (ImageView) findViewById(R.id.img_url);
//        viewStub = (ViewStub) findViewById(R.id.viewStub);
//        baseWebViewLayout = (BaseWebViewLayout) findViewById(R.id.baseWebViewLayout);
//        textView.setText(name);
//        Logger.i("TTT", "name" + name);
//        ImageLoderUtil.loadImage(R.drawable.icon_driver, img_icon);
//        String url = "http://avis-img.oss-cn-shanghai.aliyuncs.com/chauffeur/head/c79ab6a702ef981097fbbd0a869596f5.png?x-oss-process=image/resize,m_pad,h_330,w_390";
//        ImageLoderUtil.loadCircleImage(url, img_url);
////        looperThread.start();
//        new GenericController<String>().setName("");
//        threadTroller.excut();
//        if(viewStub!=null){
//            view_data=viewStub.inflate();
//        }
//        if(view_data==null){
//            view_data=findViewById(R.id.emty_view_id);
//        }
//        if(view_data!=null){
//            view_data.setVisibility(View.VISIBLE);
//        }
//        baseWebViewLayout.setJSInterface(JavaScriptObject.JSTOANDROIDNAME);
////        baseWebViewLayout.loadUrl("file:///android_asset/javascript.html");
//        baseWebViewLayout.loadUrl("http://html.avis.cn/cms/app/1531210557/1531210557002026.html");
//        baseWebViewLayout.setWebChromeClient(new WebChromeClient());
//       baseWebViewLayout.setWebViewClient(new BaseWebViewClient());
//        baseTitleLayout.setTitle("首页");
    }

    String gage = "";
    private List<Integer> integers = new ArrayList<>();

    @Override
    public void initRequest() {
        super.initRequest();
//        minController.setMy();
//        minController.setYours();
//        integers.clear();
//        onPress();
//        for (int i = 0; i < 10; i++) {
////                new TestThread(i + "").start();
//
////            integers.add(gage);
////            synchronized (MineActivity.this) {
////                gage = i;
////                new Thread() {
////                    @Override
////                    public void run() {
////                        super.run();
////
////                        getAge();
////
////                    }
////                }.start();
////            }
//
//        }

    }

    private void onPress() {
//        textView.setOnClickListener(this);
//        looperThread.setChangeUi(this);
    }

    public synchronized void getAge() {
//        synchronized (integers){
        Logger.i("TTT", "Thread_1" + gage);

//        }

    }

    @Override
    public void onClick(View view) {
//        baseWebViewLayout.evaluateJavascript(JavaScriptObject.JSMETH,new ObjectCallBack<String>() {
//            @Override
//            public void sussece(String s) {
//                view_data.setVisibility(View.GONE);
//                textView.setText(s);
//            }
//        });

    }

    @Override
    public void changeUi(@Nullable String content) {
//        textView.setText(content);
    }

    class TestThread extends Thread {
        private String position = "";

        TestThread(String position) {
            this.position = position;

        }

        @Override
        public void run() {
            super.run();
            synchronized (this) {
                gage = position;
                Logger.i("TTT", "Thread_1" + gage);
            }
        }
    }
}
