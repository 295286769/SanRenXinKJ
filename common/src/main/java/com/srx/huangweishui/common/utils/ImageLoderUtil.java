package com.srx.huangweishui.common.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.srx.huangweishui.common.R;
import com.srx.huangweishui.common.aplication.BaseAplication;
import com.srx.huangweishui.common.config.CircleCrop;
import com.srx.huangweishui.common.config.GlidProgressInterceptor;
import com.srx.huangweishui.common.config.MyGlideUrl;
import com.srx.huangweishui.common.inteface.ProgressListener;
import com.srx.huangweishui.common.view.BaseLineaLayout;

/**
 * Created by huangweishui on 2018/9/5.
 */

public class ImageLoderUtil {
    public static void loadCircleImage(String url, final ImageView imageView) {
        Glide.with(BaseAplication.getIntence()).load(new MyGlideUrl(url)).asBitmap().diskCacheStrategy(DiskCacheStrategy.SOURCE).placeholder(R.drawable.avatar_default).into(new BitmapImageViewTarget(imageView) {
            @Override
            protected void setResource(Bitmap resource) {
                super.setResource(resource);
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(BaseAplication.getIntence().getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                imageView.setImageDrawable(circularBitmapDrawable);
            }
        });

    }

    public static void loadImage(int drawableId, final ImageView imageView) {
        Glide.with(BaseAplication.getIntence()).load(drawableId).asBitmap().diskCacheStrategy(DiskCacheStrategy.SOURCE).transform(new CircleCrop(BaseAplication.getIntence() ))
                .override(BitmapImageViewTarget.SIZE_ORIGINAL, Target.SIZE_ORIGINAL).into(new BitmapImageViewTarget(imageView) {
            @Override
            protected void setResource(Bitmap resource) {
                super.setResource(resource);
                RoundedBitmapDrawable circularBitmapDrawable =
                        RoundedBitmapDrawableFactory.create(BaseAplication.getIntence().getResources(), resource);
                circularBitmapDrawable.setCircular(true);
                imageView.setImageDrawable(circularBitmapDrawable);
            }
        });

    }

    /**
     * 自定义view显示图片
     *
     * @param url
     * @param view
     */
    public static void loadCustomView(String url, BaseLineaLayout view) {
        Glide.with(BaseAplication.getIntence()).load(new MyGlideUrl(url)).centerCrop().into(view.getViewTarget());
    }

    /**
     * 带进度的加载
     * @param url
     * @param imageView
     */
    public static void loadViewAsLoading(String url, ImageView imageView) {
        GlidProgressInterceptor.addListener(url, new ProgressListener() {
            @Override
            public void onProgress(int progress) {
                //进度
            }
        });

        Glide.with(BaseAplication.getIntence()).load(new MyGlideUrl(url)).into(new GlideDrawableImageViewTarget(imageView){
            @Override
            public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> animation) {
                super.onResourceReady(resource, animation);
                //结束

            }

            @Override
            public void onStart() {
                super.onStart();
                //开始
            }
        });
    }
}
