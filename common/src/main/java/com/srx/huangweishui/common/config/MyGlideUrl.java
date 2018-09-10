package com.srx.huangweishui.common.config;

import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;

import java.net.URL;

/**
 * 解决网络图片有token的方案
 * Created by huangweishui on 2018/9/7.
 */

public class MyGlideUrl extends GlideUrl {
    private String mUrl;

    public MyGlideUrl(String url) {
        super(url);
        mUrl=url;
    }


    @Override
    public String getCacheKey() {
        return mUrl.replace(findTokenParam(), "");
    }
    private String findTokenParam() {
        String tokenParam = "";
        int tokenKeyIndex = mUrl.indexOf("?token=") >= 0 ? mUrl.indexOf("?token=") : mUrl.indexOf("&token=");
        if (tokenKeyIndex != -1) {
            int nextAndIndex = mUrl.indexOf("&", tokenKeyIndex + 1);
            if (nextAndIndex != -1) {
                tokenParam = mUrl.substring(tokenKeyIndex + 1, nextAndIndex + 1);
            } else {
                tokenParam = mUrl.substring(tokenKeyIndex);
            }
        }
        return tokenParam;
    }

}
