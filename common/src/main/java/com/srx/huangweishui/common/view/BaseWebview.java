package com.srx.huangweishui.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * Created by huangweishui on 2017/11/20.
 */

public class BaseWebview extends WebView {
    private Context context;

    public BaseWebview(Context context) {
        super(context);
        this.context = context;
    }

    public BaseWebview(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
    }

    public BaseWebview(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
    }
}
