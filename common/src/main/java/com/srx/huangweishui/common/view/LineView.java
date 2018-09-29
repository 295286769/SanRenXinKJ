package com.srx.huangweishui.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.srx.huangweishui.common.R;


/**
 * Created by huangweishui on 2018/5/11.
 */

public class LineView extends View {
    private Paint paint;
    private int color=getResources().getColor(R.color.base_line_color);
    public LineView(Context context) {
        this(context,null);
    }

    public LineView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public LineView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
       TypedArray typedArray= context.obtainStyledAttributes(attrs, R.styleable.LineView);
        if(typedArray!=null){
            color= typedArray.getColor(R.styleable.LineView_line_color,getResources().getColor(R.color.base_line_color));
            typedArray.recycle();
        }
        paint=new Paint();
        paint.setAntiAlias(true);
        paint.setColor(color);
    }
    public void setLineColor(int color){
        if(paint!=null){
            paint.setColor(color);
            postInvalidate();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(paint!=null){
            canvas.drawRect(0,0,getWidth(),getHeight(),paint);
        }
    }
}
