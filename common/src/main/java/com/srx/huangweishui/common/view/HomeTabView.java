package com.srx.huangweishui.common.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.srx.huangweishui.common.R;
import com.srx.huangweishui.common.utils.ScreenUtils;


/**
 * Created by huangweishui on 2017/9/6.
 */

public class HomeTabView extends LinearLayout {
    LinearLayout ll_tab;
    RadioButton rbPickAirport;//接机
    RadioButton rbSendAirport;//送机
    RadioButton rbPointToPoint;//点到点
    RadioButton rbHartered;//包车
    RadioGroup radiogroupMain;
    ImageView tv_tab_line;
    LineView lineView;
    LineView lineViewTop;
    private Context context;
    private int offset = 0;// 动画图片偏移量
    private int currIndex = 0;// 当前页卡编号
    private int lineWith;
    int one;
    int two;
    int three;
    int startLocation;
    int  select_color;
    int  base_line_view_top_color;
    int  item_size;
    private int item_text_size=0;
//    private int marginright_size=0;
//    private int marginleft_size=0;
    private String item_one_text="";
    private String item_two_text="";
    private String item_three_text="";
    private String item_four_text="";
    private boolean item_one_visble;
    private boolean item_two_visble;
    private boolean item_three_visble;
    private boolean item_four_visble;
    private boolean base_tab_line_visble;
    private boolean base_line_view_top_visible;

    public HomeTabView(Context context) {
        this(context, null);
    }

    public HomeTabView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HomeTabView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.homeTabView);
        if(typedArray!=null){
            select_color=typedArray.getResourceId(R.styleable.homeTabView_text_select_color,R.color.home_tab_text_color);
            base_line_view_top_color=typedArray.getColor(R.styleable.homeTabView_base_line_view_top_color,getResources().getColor(R.color.default_font_categary_color));
            item_text_size= (int) typedArray.getDimension(R.styleable.homeTabView_item_text_size,0);
//            marginright_size= (int) typedArray.getDimension(R.styleable.homeTabView_marginright_size,0);
//            marginleft_size= (int) typedArray.getDimension(R.styleable.homeTabView_marginleft_size,0);
            item_size=typedArray.getInteger(R.styleable.homeTabView_item_size,4);
            item_one_text= TextUtils.isEmpty(typedArray.getString(R.styleable.homeTabView_item_one_text))?"":typedArray.getString(R.styleable.homeTabView_item_one_text);
            item_two_text= TextUtils.isEmpty(typedArray.getString(R.styleable.homeTabView_item_two_text))?"":typedArray.getString(R.styleable.homeTabView_item_two_text);
            item_three_text= TextUtils.isEmpty(typedArray.getString(R.styleable.homeTabView_item_three_text))?"":typedArray.getString(R.styleable.homeTabView_item_three_text);
            item_four_text= TextUtils.isEmpty(typedArray.getString(R.styleable.homeTabView_item_four_text))?"":typedArray.getString(R.styleable.homeTabView_item_four_text);
            item_one_visble= typedArray.getBoolean(R.styleable.homeTabView_item_one_visble,true);
            item_two_visble= typedArray.getBoolean(R.styleable.homeTabView_item_two_visble,true);
            item_three_visble= typedArray.getBoolean(R.styleable.homeTabView_item_three_visble,true);
            item_four_visble= typedArray.getBoolean(R.styleable.homeTabView_item_four_visble,true);
            base_tab_line_visble= typedArray.getBoolean(R.styleable.homeTabView_base_tab_line_visble,true);
            base_line_view_top_visible= typedArray.getBoolean(R.styleable.homeTabView_base_line_view_top_visible,true);
            typedArray.recycle();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.activity_home_tab_view, this,
                true);
        ll_tab = (LinearLayout) view.findViewById(R.id.ll_tab);
        radiogroupMain = (RadioGroup) view.findViewById(R.id.radiogroup_main);
        rbPickAirport = (RadioButton) view.findViewById(R.id.rb_pick_airport);
        rbSendAirport = (RadioButton) view.findViewById(R.id.rb_send_airport);
        rbPointToPoint = (RadioButton) view.findViewById(R.id.rb_point_to_point);
        rbHartered = (RadioButton) view.findViewById(R.id.rb_hartered);
        tv_tab_line = (ImageView) view.findViewById(R.id.tv_tab_line);
        lineViewTop = (LineView) view.findViewById(R.id.line_view_top);
        lineView = (LineView) view.findViewById(R.id.lineView);
        rbPickAirport.setTextColor(getResources().getColorStateList(select_color));
        rbSendAirport.setTextColor(getResources().getColorStateList(select_color));
        rbPointToPoint.setTextColor(getResources().getColorStateList(select_color));
        rbHartered.setTextColor(getResources().getColorStateList(select_color));
        if(base_line_view_top_visible){
            lineViewTop.setVisibility(VISIBLE);
            lineViewTop.setLineColor(base_line_view_top_color);
        }

        if(item_size==3){
            rbHartered.setVisibility(GONE);
        }else if(item_size==2){
            rbHartered.setVisibility(GONE);
            rbPointToPoint.setVisibility(GONE);
        }
        if(!item_one_visble){
            rbPickAirport.setVisibility(INVISIBLE);
        }
        if(!item_two_visble){
            rbSendAirport.setVisibility(INVISIBLE);
        }
        if(!item_three_visble){
            rbPointToPoint.setVisibility(INVISIBLE);
        }
        if(!item_four_visble){
            rbHartered.setVisibility(INVISIBLE);
        }
        if(item_text_size>0){
            rbPickAirport.setTextSize(TypedValue.COMPLEX_UNIT_PX,item_text_size);
            rbSendAirport.setTextSize(TypedValue.COMPLEX_UNIT_PX,item_text_size);
            rbPointToPoint.setTextSize(TypedValue.COMPLEX_UNIT_PX,item_text_size);
            rbHartered.setTextSize(TypedValue.COMPLEX_UNIT_PX,item_text_size);
        }
        if(!TextUtils.isEmpty(item_one_text)){
            setRbPickAirportContent(item_one_text);
        }

        if(!TextUtils.isEmpty(item_two_text)){
            setRbSendAirportContent(item_two_text);
        }
        if(!TextUtils.isEmpty(item_three_text)){
            setRbPointToPointContent(item_three_text);
        }
        if(!TextUtils.isEmpty(item_four_text)){
            setRbHarteredContent(item_four_text);
        }
//        if(marginleft_size>0||marginright_size>0){
//            MarginLayoutParams marginLayoutParams= (MarginLayoutParams) ll_tab.getLayoutParams();
//            if(marginLayoutParams!=null){
//                marginLayoutParams.leftMargin=marginleft_size;
//                marginLayoutParams.rightMargin=marginright_size;
//                ll_tab.setLayoutParams(marginLayoutParams);
//            }
//
//        }
        if(!base_tab_line_visble){
            tv_tab_line.setVisibility(INVISIBLE);
        }else {
            if(tv_tab_line.getVisibility()==GONE||tv_tab_line.getVisibility()==INVISIBLE){
                tv_tab_line.setVisibility(VISIBLE);
            }

        }


    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if(base_tab_line_visble){
            initLineLocation();
        }
    }

    private void initLineLocation() {
//        lineWith = ScreenUtils.dpToPx(context, 30);
        lineWith = tv_tab_line.getMeasuredWidth();
//        int screenW = ScreenUtils.getScreenWidth(context);// 获取分辨率宽度
        int screenW = getMeasuredWidth();// 获取分辨率宽度
//        int piddingleft=getPaddingLeft();
//        int piddingright=getPaddingRight();
        offset = (screenW / item_size - lineWith) / 2;// 计算偏移量
        startLocation = offset;
        one = offset * 2 + lineWith + startLocation;// 页卡1 -> 页卡2 偏移量
        two = (offset * 2 + lineWith) * 2 + startLocation;// 页卡1 -> 页卡3 偏移量
        three = (offset * 2 + lineWith) * 3 + startLocation;// 页卡1 -> 页卡4偏移量

        Animation animation = new TranslateAnimation(0, startLocation,
                0, 0);
        animation.setFillAfter(true);// True:图片停在动画结束位置
        tv_tab_line.startAnimation(animation);
    }

    public void setRbPickAirportContent(String content) {
        if (rbPickAirport != null) {
            rbPickAirport.setText(content);
        }
    }

    public void setRbSendAirportContent(String content) {
        if (rbSendAirport != null) {
            rbSendAirport.setText(content);
        }
    }
    public RadioButton getRbSendAirportContent() {
        return rbSendAirport;
    }

    public void setRbPointToPointContent(String content) {
        if (rbPointToPoint != null) {
            rbPointToPoint.setText(content);
        }
    }
    public RadioButton getRbPointToPointContent() {
        return rbPointToPoint;
    }

    public void setRbHarteredContent(String content) {
        if (rbHartered != null) {
            rbHartered.setText(content);
        }
    }

    public RadioGroup getRadiogroupMain() {
        return radiogroupMain;
    }
    public void setRadioGroupOnPress(RadioGroup.OnCheckedChangeListener radioGroupOnPress){
        if(radiogroupMain!=null){
            radiogroupMain.setOnCheckedChangeListener(radioGroupOnPress);
        }
    }


    //接机
    public void setPickAirportOnPress(OnClickListener pickAirportOnPress) {
        rbPickAirport.setOnClickListener(pickAirportOnPress);
    }

    //送机
    public void setPickSendAirport(OnClickListener clickListener) {
        rbSendAirport.setOnClickListener(clickListener);
    }

    //点对点
    public void setPointToPoint(OnClickListener clickListener) {
        rbPointToPoint.setOnClickListener(clickListener);
    }

    //包机
    public void setHartered(OnClickListener clickListener) {
        rbHartered.setOnClickListener(clickListener);
    }
    public void setLineViewVisible(int visible){
        if(lineView!=null){
            lineView.setVisibility(visible);
        }
    }

    public void startLineAnimation(int index) {
        if(base_tab_line_visble&&tv_tab_line.getVisibility()==VISIBLE){
            Animation animation = null;
            switch (index) {
                case 0:
                    if (currIndex == 1) {
                        animation = new TranslateAnimation(one, startLocation, 0, 0);
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, startLocation, 0, 0);
                    } else if (currIndex == 3) {
                        animation = new TranslateAnimation(three, startLocation, 0, 0);
                    }
                    break;
                case 1:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(startLocation, one, 0, 0);
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, one, 0, 0);
                    } else if (currIndex == 3) {
                        animation = new TranslateAnimation(three, one, 0, 0);
                    }
                    break;
                case 2:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(startLocation, two, 0, 0);
                    } else if (currIndex == 1) {
                        animation = new TranslateAnimation(one, two, 0, 0);
                    } else if (currIndex == 3) {
                        animation = new TranslateAnimation(three, two, 0, 0);
                    }
                    break;
                case 3:
                    if (currIndex == 0) {
                        animation = new TranslateAnimation(startLocation, three, 0, 0);
                    } else if (currIndex == 1) {
                        animation = new TranslateAnimation(one, three, 0, 0);
                    } else if (currIndex == 2) {
                        animation = new TranslateAnimation(two, three, 0, 0);
                    }
                    break;
            }
            if (currIndex != index) {
                currIndex = index;
                animation.setFillAfter(true);// True:图片停在动画结束位置
                animation.setDuration(200);
                tv_tab_line.startAnimation(animation);
            }
        }


    }

    public void cleaAnimation() {
        if (tv_tab_line != null) {
            tv_tab_line.clearAnimation();
        }
    }

}
