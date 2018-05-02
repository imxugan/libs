package test.cn.example.com.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/**
 * Created by xugan on 2018/5/2.
 */

public class ToastUtils {
    private ToastUtils() {
        throw new UnsupportedOperationException("ToastUtils cannot be instantiated");
    }

    protected void debugToast(Context context,String string){
        if(BuildConfig.DEBUG){
            shortToast(context,string);
        }
    }

    /**
     * 短提示 by resId
     *
     * @param resId
     */
    public static void shortToast(Context context,int resId) {
        toastResId(context, resId, Toast.LENGTH_SHORT);
    }

    /**
     * 短提示 by String
     *
     * @param string
     */
    public static void shortToast(Context context,String string) {
        toastString(context,string, Toast.LENGTH_SHORT);
    }

    /**
     * 长提示 by resId
     *
     * @param resId
     */
    public static void longToast(Context context,int resId) {
        toastResId(context,resId, Toast.LENGTH_LONG);
    }

    /**
     * 常提示 by String
     *
     * @param string
     */
    public static void longToast(Context context,String string) {
        toastString(context,string, Toast.LENGTH_LONG);
    }

    private static Handler h=new Handler(Looper.getMainLooper());
    /**
     * 判断时间间隔提示Toast by String
     *
     * @param str      文字
     * @param showTime
     */
    private static void toastString(final Context context,final String str, final int showTime) {
        h.post(new Runnable() {
            @Override
            public void run() {
                MyToast.getToast(context, str, showTime).show();
            }
        });
    }

    /**
     * 判断时间间隔提示Toast by resId
     * @param resId
     * @param showTime
     */
    private static void toastResId(Context context,int resId, int showTime) {
        toastString(context,context.getString(resId), showTime);
    }

    /**
     * 自定义Toast类
     *
     * @author blj
     */
    private static class MyToast {
        private static Toast toast = null;

        public static Toast getToast(Context context, String words, int showTime) {
            if (toast!=null) {
                toast.setText(words);
                toast.setDuration(showTime);
            } else {
                toast = Toast.makeText(context, words, showTime);
            }
            return toast;
        }
    }
}
