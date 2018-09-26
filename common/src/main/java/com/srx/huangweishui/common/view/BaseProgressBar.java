package com.srx.huangweishui.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.srx.huangweishui.common.R;


/**
 * Created by huangweishui on 2018/7/26.
 */

public class BaseProgressBar extends LinearLayout {
    private ProgressBar progressBar;
    public BaseProgressBar(Context context) {
        this(context,null);
    }

    public BaseProgressBar(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BaseProgressBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view= LayoutInflater.from(context).inflate(R.layout.base_progress_bar,this,true);
        progressBar=(ProgressBar)view.findViewById(R.id.progressBar);
    }
    public void setProgress(int progress){
        if(progressBar!=null){
            progressBar.setProgress(progress);
        }
    }
    public int getProgress(int progress){
        if(progressBar!=null){
           return progressBar.getProgress();

        }
        return 0;
    }
    public void setProgressColor(int colorDrawable){
        if(progressBar!=null){
            progressBar.setBackgroundResource(colorDrawable);
        }
    }
}
