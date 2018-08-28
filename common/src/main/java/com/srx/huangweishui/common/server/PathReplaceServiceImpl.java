package com.srx.huangweishui.common.server;

import android.content.Context;
import android.net.Uri;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.service.PathReplaceService;

/**
 * Created by huangweishui on 2018/8/28.
 */
@Route(path="test/server" )
public class PathReplaceServiceImpl implements PathReplaceService {
    @Override
    public String forString(String path) {
        return path;
    }

    @Override
    public Uri forUri(Uri uri) {
        return uri;
    }

    @Override
    public void init(Context context) {

    }
}
