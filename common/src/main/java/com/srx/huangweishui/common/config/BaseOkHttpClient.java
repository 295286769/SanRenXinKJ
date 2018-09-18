package com.srx.huangweishui.common.config;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by huangweishui on 2018/9/11.
 */

public class BaseOkHttpClient {
    private static BaseOkHttpClient baseOkHttpClient;
    private OkHttpClient okHttpClient;
    private Request.Builder builder;

    private BaseOkHttpClient(){

    }
    public static void getOkHttpClient(){
        if(baseOkHttpClient==null){
            synchronized (BaseOkHttpClient.class){
                if(baseOkHttpClient==null){
                    baseOkHttpClient=new BaseOkHttpClient();
                }
            }
        }
    }
    public void init(){
        if(okHttpClient==null){
            okHttpClient=new OkHttpClient();
            builder=new Request.Builder();
            builder.url("url");
            builder.addHeader("","");


        }


    }
    public void getRequst(String url){
        builder.url(url);
        Request request=builder.build();
         okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }
}
