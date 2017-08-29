package test.cn.example.com.util;

import android.content.Context;
import android.content.res.Resources;

/**
 * Created by xgxg on 2017/8/9.
 */

public class DensityUtil {
    private static final float DENSITY = Resources.getSystem().getDisplayMetrics().density;

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    public static int dp2Px(int dp){
        return Math.round(dp * DENSITY);
    }


}
