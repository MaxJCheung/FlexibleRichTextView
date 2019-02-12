package com.daquexian.flexiblerichtextview;

import android.content.res.Resources;

/**
 * Create by jiancheung on 2019/2/12
 *
 * 　＃＃＃　　＃＃＃＃　　　　　　＃＃　　　　　　　　＃＃＃　＃＃＃
 * 　　＃＃　　＃＃　　　　　　　　＃＃＃　　　　　　　　＃＃　＃＃
 * 　　＃＃＃　＃＃　　　　　　　　＃＃＃　　　　　　　　＃＃＃＃
 * 　　＃＃＃＃＃＃　　　　　　　＃＃＃＃＃　　　　　　　　＃＃＃
 * 　　＃＃＃＃＃＃　　　　　　　＃＃＃＃＃　　　　　　　＃＃＃＃
 * 　　＃　＃＃　＃　　　　　　＃＃　　＃＃　　　　　　　＃＃　＃＃
 * 　＃＃＃＃＃＃＃＃＃　　　＃＃＃　　＃＃＃　　　　＃＃＃＃　＃＃＃
 */
public class SizeUtil {

    public static int dp2px(final float dpValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * Value of px to value of dp.
     *
     * @param pxValue The value of px.
     * @return value of dp
     */
    public static int px2dp(final float pxValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * Value of sp to value of px.
     *
     * @param spValue The value of sp.
     * @return value of px
     */
    public static int sp2px(final float spValue) {
        final float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * Value of px to value of sp.
     *
     * @param pxValue The value of px.
     * @return value of sp
     */
    public static int px2sp(final float pxValue) {
        final float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

}
