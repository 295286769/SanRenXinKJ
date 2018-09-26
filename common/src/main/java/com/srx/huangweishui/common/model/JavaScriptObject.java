package com.srx.huangweishui.common.model;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;

import com.google.gson.Gson;
import com.srx.huangweishui.common.utils.ToasterManager;

/**
 * Created by yaoqian on 2018/3/7.
 */
public class JavaScriptObject {
    public final static String JSMETH="wave()";
    public final static String JSTOANDROIDNAME="AndroidObject";
    private Context mContxt;
    private String jsname;

    public JavaScriptObject(Context mContxt, String jsname) {
        this.mContxt = mContxt;
        this.jsname=jsname;
    }

    @JavascriptInterface
    public void goToRental(String message) {
        try{
            if(!TextUtils.isEmpty(message)){
                JsonO jsonO=new Gson().fromJson(message,JsonO.class);
                if(jsonO!=null){
                  switch (jsonO.getPage()){
                      case "index":
                          //租车首页
//                          ActivityStartUtils.startTakeCarActivity(mContxt);
//                          EventBus.getDefault().post(new FinishAdvertisementEvent());
                          break;
                      default:
                          break;
                  }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 专车评价订单js交互
     */
    @JavascriptInterface
    public void evaluateSuccess(int status) {

//        EventBus.getDefault().post(new OrderEvaluationEvent(true, ""));
    }
    @JavascriptInterface
    public void onJsCallback(){
        ToasterManager.showShortToast("js调用了我");

    }

    public  class JsonO{
        private String page;
        public String getPage() {
            return TextUtils.isEmpty(page) ? "" : page;
        }
    }

}
