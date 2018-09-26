package com.srx.huangweishui.common.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.srx.huangweishui.common.R;
import com.srx.huangweishui.common.inteface.ObjectCallBack;
import com.srx.huangweishui.common.model.JavaScriptObject;


/**
 * Created by huangweishui on 2017/11/20.
 */

public class BaseWebViewLayout extends LinearLayout {
    private Context context;
    private BaseWebview webview;
    private BaseProgressBar baseProgressBar;
    private boolean pregressVisible=false;//是否显示进度条
    private int pregressColor=-1;//进度条颜色

    public BaseWebViewLayout(Context context) {
        this(context, null);
    }

    public BaseWebViewLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BaseWebViewLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        TypedArray typedArray=context.obtainStyledAttributes(attrs, R.styleable.baseWebViewLayout);
        if(typedArray!=null){
            pregressVisible=typedArray.getBoolean(R.styleable.baseWebViewLayout_base_pregress_isvisible,false);
            pregressColor=typedArray.getResourceId(R.styleable.baseWebViewLayout_base_pregress_color,-1);
            typedArray.recycle();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.base_web_view, this, true);
        webview = (BaseWebview) view.findViewById(R.id.webview);
        baseProgressBar = (BaseProgressBar) view.findViewById(R.id.baseProgressBar);
        if(pregressColor!=-1){
            baseProgressBar.setProgressColor(pregressColor);
        }
        if(pregressVisible){
            baseProgressBar.setVisibility(View.VISIBLE);
        }else{
            baseProgressBar.setVisibility(View.GONE);
        }
        initWebview();
    }

    private void initWebview() {
        WebSettings settings = webview.getSettings();
        settings.setDefaultTextEncodingName("utf-8");  //设置编码
        settings.setJavaScriptCanOpenWindowsAutomatically(true);// 设置js可以直接打开窗口，如window.open()，默认为false
        settings.setJavaScriptEnabled(true);// 是否允许执行js，默认为false。设置true时，会提醒可能造成XSS漏洞
        settings.setBuiltInZoomControls(true);
        settings.setSavePassword(false);
        settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
        settings.setLoadWithOverviewMode(true);
        settings.setUseWideViewPort(true);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);// 是否使用缓存
        settings.setDomStorageEnabled(true);// DOM Storage
        //关闭这些接口防止恶意攻击
        webview.removeJavascriptInterface("searchBoxJavaBridge_");
        webview.removeJavascriptInterface("accessibilityTraversal");
        webview.removeJavascriptInterface("accessibility");
    }

    public void loadUrl(String url) {
        if (webview != null) {
            webview.loadUrl(url);
        }
    }

    /**
     * android调用js
     * @param jsString
     * @param callBack
     */
    public void evaluateJavascript(final String jsString,final ObjectCallBack<String> callBack){

        if(webview!=null){
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                        webview.evaluateJavascript(jsString, new ValueCallback<String>() {
                            @Override
                            public void onReceiveValue(String value) {
                                callBack.sussece(value);
                            }
                        });
                    }else {
                        webview.loadUrl("javascript:wave()");
                    }
        }
    }


    /**
     * 加载本地html
     * @param url
     */
    public void loadDataWithURL(String url) {
        if (webview != null) {
            webview.loadUrl(url);
            //  加载、并显示HTML代码
            webview.loadDataWithBaseURL(null, url, "text/html" , "utf-8", null);
        }
    }

    /**
     * js掉android
     * @param jsname
     */
    @SuppressLint({ "JavascriptInterface", "SetJavaScriptEnabled" })
    public void setJSInterface(String jsname) {
        if (webview != null) {
            webview.addJavascriptInterface(new JavaScriptObject(context,jsname), jsname);
        }
    }
    public void setWebViewClient(WebViewClient webViewClient) {
        if (webview != null) {
            webview.setWebViewClient(webViewClient);
        }
    }
    public void setProgress(int progress){
        if(baseProgressBar!=null){
            if(pregressVisible){
                if (progress == 100) {
                    setProgressBarVisble(GONE);
                } else {
                    if (baseProgressBar.getVisibility() == GONE)
                        setProgressBarVisble(VISIBLE);
                    baseProgressBar.setProgress(progress);
                }
            }

        }
    }
    public void setWebChromeClient(WebChromeClient webChromeClient) {
        if (webview != null) {
            webview.setWebChromeClient(webChromeClient);
        }
    }

    public void setProgressBarVisble(int visible){
        if(baseProgressBar!=null){
            baseProgressBar.setVisibility(visible);
        }
    }
    public WebView getWebView(){
        return webview;
    }

    /*
         * (non-Javadoc) 监听回退事件
         */
    @SuppressLint("NewApi")
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webview.canGoBack()) {
                webview.goBack();// 返回
            } else {
                if (context != null) {
                    ((Activity) context).finish();
                }

            }
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }


}
