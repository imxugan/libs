package test.cn.example.com.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;

/**
 * Created by xgxg on 2017/8/28.
 */

public class BitmapUtils {
    private BitmapUtils(){}

    private static final Canvas sCanvas = new Canvas();

    /**
     * 控件的Bitmap对象复制了一份，然后返回
     * @param view
     * @return
     */
    public  static Bitmap createBitmapFromView(View view){
        if(null == view ){
            return null;
        }
        view.clearFocus();
        Bitmap bitmap = createBitmapSafely(view.getWidth(),view.getHeight(),Bitmap.Config.ARGB_8888,1);
        if(null != bitmap){
            synchronized (sCanvas){
                Canvas canvas = sCanvas;
                canvas.setBitmap(bitmap);
                view.draw(canvas);
                canvas.setBitmap(null);
            }
        }
        return bitmap;
    }

    private static Bitmap createBitmapSafely(int width, int height, Bitmap.Config config, int retryCount) {

        try {
            return Bitmap.createBitmap(width,height,config);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            if(retryCount>0){
                System.gc();
                return createBitmapSafely(width,height,config,retryCount-1);
            }
            return null;
        }
    }

}
