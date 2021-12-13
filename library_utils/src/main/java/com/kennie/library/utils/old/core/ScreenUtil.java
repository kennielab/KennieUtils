package com.kennie.library.utils.old.core;

import android.content.res.Configuration;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import com.kennie.library.utils.KennieUtilInit;

/**
 * @项目名 KennieUtils
 * @类名称 ScreenUtil
 * @类描述
 * @创建人 Kennie
 * @修改人
 * @创建时间 2021/11/18 22:45
 */
public class ScreenUtil {


    /**
     * 获取屏幕宽度
     *
     * @return
     */
    public static int getScreenWidth() {
        DisplayMetrics displayMetrics = KennieUtilInit.getApp().getResources().getDisplayMetrics();
        return displayMetrics.widthPixels;
    }


    /**
     * 获取屏幕高度
     *
     * @return
     */
    public static int getScreenHeight() {
        DisplayMetrics displayMetrics = KennieUtilInit.getApp().getResources().getDisplayMetrics();
        return displayMetrics.heightPixels;
    }


    /**
     * 获取屏幕密度
     *
     * @return
     */
    public static float getScreenDensity() {
        DisplayMetrics displayMetrics = KennieUtilInit.getApp().getResources().getDisplayMetrics();
        return displayMetrics.density;
    }

    /**
     * 获取屏幕宽度和高度
     *
     * @return
     */
    public static ScreenSize getScreenSize() {
        DisplayMetrics displayMetrics = KennieUtilInit.getApp().getResources().getDisplayMetrics();
        return new ScreenSize(displayMetrics.widthPixels, displayMetrics.heightPixels);
    }


    /**
     * dp转换为px
     *
     * @param dp
     * @return
     */
    public static int dp2px(float dp) {
        return xp2px(dp, TypedValue.COMPLEX_UNIT_DIP);
    }


    /**
     * sp转换为px
     *
     * @param sp
     * @return
     */
    public static int sp2px(float sp) {
        return xp2px(sp, TypedValue.COMPLEX_UNIT_SP);
    }

    private static int xp2px(float f, int unit) {
        DisplayMetrics displayMetrics = KennieUtilInit.getApp().getResources().getDisplayMetrics();
        return (int) TypedValue.applyDimension(unit, f, displayMetrics);

    }

    /**
     * 获取状态栏高度
     *
     * @return 状态栏高度
     */
    public static int getStatusBarHeight() {
        int statusHeight = 0;
        int resourceId = KennieUtilInit.getApp().getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusHeight = KennieUtilInit.getApp().getResources().getDimensionPixelSize(resourceId);
        }
        return statusHeight;
    }


    /**
     * 获取导航栏高度
     *
     * @return 导航栏高度
     */
    public static int getNavigationBarHeight() {
        String field = "";
        if (KennieUtilInit.getApp().getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            field = "navigation_bar_height";
        } else {
            field = "navigation_bar_height_landscape";
        }
        int resourceId = KennieUtilInit.getApp().getResources().getIdentifier(field, "dimen", "android");
        if (resourceId > 0) {
            return KennieUtilInit.getApp().getResources().getDimensionPixelSize(resourceId);
        } else {
            return 0;
        }
    }


    /**
     * 获取ActionBar高度
     *
     * @return ActionBar高度
     */
    public static int getActionBarHeight() {
        int height = 0;
        TypedValue tv = new TypedValue();
        if (KennieUtilInit.getApp().getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            height = TypedValue.complexToDimensionPixelSize(tv.data, KennieUtilInit.getApp().getResources().getDisplayMetrics());
        }
        return height;
    }


    public static class ScreenSize {

        private int width;
        private int height;

        public ScreenSize(int width, int height) {
            this.width = width;
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public int getHeight() {
            return height;
        }


        @Override
        public String toString() {
            return width + "x" + height;
        }

    }
}
