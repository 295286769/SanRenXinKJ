package com.srx.huangweishui.common.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.srx.huangweishui.common.aplication.BaseKotlinAplication;

public class ScreenUtils {
    /**
     * @param context
     * @return
     */
    private static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics outMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics;
    }

    /**
     * @param context
     * @return
     */
    public static int getScreenWidth(Context context) {
        return getDisplayMetrics(context).widthPixels;
    }

    /**
     * @param context
     * @return
     */
    public static int getScreenHeight(Context context) {
        return getDisplayMetrics(context).heightPixels;
    }

    /**
     * @param context
     * @return
     */
    public static float getDensity(Context context) {
        return getDisplayMetrics(context).density;
    }

    /**
     * @param context
     * @return
     */
    public static String getDensityDpi(Context context) {
        String strDensityDpi;
        int densityDpi = getDisplayMetrics(context).densityDpi;
        switch (densityDpi) {
            case DisplayMetrics.DENSITY_LOW:
                strDensityDpi = "LDPI";
                break;
            case DisplayMetrics.DENSITY_MEDIUM:
                strDensityDpi = "MDPI";
                break;
            case DisplayMetrics.DENSITY_HIGH:
                strDensityDpi = "HDPI";
                break;
            case DisplayMetrics.DENSITY_XHIGH:
                strDensityDpi = "XHDPI";
                break;
            default:
                strDensityDpi = "XXHDPI";
                break;
        }
        return strDensityDpi;
    }

    /**
     * must not run before onPostCreate()
     */
    public static int getStatusBarHeight(Activity activity) {
        Rect rect = new Rect();
        activity.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
        return rect.top;
    }

    /**
     * @param context
     * @param dp
     * @return
     */
    public static int dpToPx(Context context, float dp) {
        if (context == null) {
            return -1;
        }
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    /**
     * @param context
     * @param px
     * @return
     */
    public static int pxToDp(Context context, float px) {
        if (context == null) {
            return -1;
        }
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (px / scale + 0.5f);
    }

    public static int getWindowsWidth() {
        WindowManager wm = (WindowManager) BaseKotlinAplication.Companion.getIncetence().getSystemService(Context.WINDOW_SERVICE);
        return wm.getDefaultDisplay().getWidth();
    }


}
