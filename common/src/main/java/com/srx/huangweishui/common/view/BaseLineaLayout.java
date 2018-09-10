package com.srx.huangweishui.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.ViewTarget;

/**
 * Created by huangweishui on 2018/9/7.
 */

public class BaseLineaLayout extends LinearLayout {
    private ViewTarget<BaseLineaLayout,GlideDrawable> viewTarget;
    public BaseLineaLayout(Context context) {
        this(context,null);
    }

    public BaseLineaLayout(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BaseLineaLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initViewTaget();
    }

    private void initViewTaget() {
        viewTarget=new ViewTarget<BaseLineaLayout, GlideDrawable>(this) {
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                setImageAsBackground(resource);
            }
        };
    }

    public ViewTarget<BaseLineaLayout, GlideDrawable> getViewTarget() {
        return viewTarget;
    }
    public void setImageAsBackground(GlideDrawable resource) {
        setBackground(resource);
    }
}
