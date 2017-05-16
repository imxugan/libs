package test.cn.example.com.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/**
 * Toast 工具类
 * Created by xgxg on 2017/5/16.
 */

public class T {    //静态变量导致context泄漏问题,使用App Context
    private static Toast toast = null;
    private static Handler h = new Handler(Looper.getMainLooper());

    private T() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 判断时间间隔提示Toast by String
     *  @param str      文字
     * @param duration
     */
    private static void toastString(final Context context,final String str, final int duration) {
        h.post(new Runnable() {
            @Override
            public void run() {
                if (toast != null) {
                    toast.setText(str);
                    toast.setDuration(duration);
                } else {
                    toast = Toast.makeText(context, str, duration);
                }
                toast.show();
            }
        });
    }

    public static void show(Context context, int message, int duration) {
        if (context != null) {
            if (toast == null) {
                toast = Toast.makeText(context.getApplicationContext(), message, duration);
            } else {
                toast.setText(message);
            }
            toast.show();
        }
    }

}
