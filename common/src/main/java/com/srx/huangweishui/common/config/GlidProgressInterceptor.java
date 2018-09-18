package com.srx.huangweishui.common.config;

import com.srx.huangweishui.common.inteface.ProgressListener;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * glide拦截器
 * Created by huangweishui on 2018/9/11.
 */

public class GlidProgressInterceptor implements Interceptor {
    static final Map<String, ProgressListener> LISTENER_MAP = new HashMap<>();

    public static void addListener(String url, ProgressListener listener) {
        if(LISTENER_MAP.get(url)==null){
            LISTENER_MAP.put(url, listener);
        }

    }

    public static void removeListener(String url) {
        LISTENER_MAP.remove(url);
    }
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Response response = chain.proceed(request);
        String url = request.url().toString();
        ResponseBody body = response.body();
        Response newResponse = response.newBuilder().body(new ProgressResponseBody(url, body)).build();
        return newResponse;
    }
}
