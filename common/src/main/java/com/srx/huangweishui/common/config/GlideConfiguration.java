package com.srx.huangweishui.common.config;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.request.target.ViewTarget;
import com.srx.huangweishui.common.R;

/**
 * Created by huangweishui on 2018/9/5.
 */

public class GlideConfiguration  implements GlideModule{
    @Override
    public void applyOptions(Context context, GlideBuilder builder) {
        builder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888);
        ViewTarget.setTagId(R.id.glide_tag_id);
    }

    @Override
    public void registerComponents(Context context, Glide glide) {

    }
}
