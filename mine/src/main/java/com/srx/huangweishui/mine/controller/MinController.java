package com.srx.huangweishui.mine.controller;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.LruCache;

import com.bumptech.glide.disklrucache.DiskLruCache;
import com.srx.huangweishui.common.aplication.BaseAplication;
import com.srx.huangweishui.common.utils.AppConstantUtils;
import com.srx.huangweishui.common.utils.Logger;
import com.srx.huangweishui.common.utils.StringUtils;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.ref.SoftReference;

/**
 * Created by huangweishui on 2018/9/4.
 */

public class MinController {
    private Context mContext;
    private boolean isMy=false;
    SoftReference<Context> softReference=null;
    private LruCache<String,Bitmap> lruCache;
    private DiskLruCache diskLruCache;

    public MinController(Context context){
        softReference=new SoftReference<Context>(context);
        mContext=softReference.get();
        int lruSize= (int) ((Runtime.getRuntime().maxMemory()/1024)/8);
        lruCache=new LruCache<String,Bitmap>( lruSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {//①设置LruCache缓存的大小，一般为当前进程可用容量的1/8。②重写sizeOf方法，计算出要缓存的每张图片的大小。
                return value.getRowBytes()*value.getHeight()/1024;
            }
        };
//        lruCache.put("","");
        if(mContext!=null){
            try {
                File cacheDir = AppConstantUtils.getDiskCacheDir(mContext, "bitmap");


                    diskLruCache=DiskLruCache.open(cacheDir
                        , AppConstantUtils.getVersionCode(BaseAplication.getIntence()),1, 10 * 1024 * 1024);
                String url="";
                DiskLruCache.Editor editor= diskLruCache.edit(StringUtils.hashKeyForDisk(url));
                String outputStream = editor.getString(0);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public  void setMy(){
        getIsMy(true);
    }
    public  void setYours(){
        getIsMy(false);
    }
    private synchronized void getIsMy(final boolean is){
        isMy=is;
        new Thread(){
            @Override
            public void run() {
                super.run();

                Logger.i("TTT","getIsMy+"+isMy);
                synchronized (this){


                }

            }
        }.start();

    }

}
