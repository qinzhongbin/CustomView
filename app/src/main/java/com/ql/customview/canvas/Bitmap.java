package com.ql.customview.canvas;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.ql.customview.R;

/**
 * Author: ql
 * Date: 2018/6/12
 * Desc: 绘制位图
 * 1.drawBitmap(Bitmap bitmap, Matrix matrix, Paint paint)
 * 2.drawBitmap(Bitmap bitmap, float left, float top, Paint paint)
 * 3.drawBitmap(Bitmap bitmap, Rect src, Rect dst, Paint paint)
 */
public class Bitmap extends View {

    private Paint paint;
    private Resources resources;
    private android.graphics.Bitmap bitmap;
    private Canvas canvas;

    public Bitmap(Context context) {
        this(context, null);
    }

    public Bitmap(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Bitmap(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    private void init(Context context) {
        paint = new Paint();

//        1.资源文件
        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test_03);
//        2.资源文件
//        bitmap = BitmapFactory.decodeFile("/sdcard/bitmap.png");
//        3.本地文件
//        try {
//            InputStream is = context.getAssets().open("bitmap.png");
//            bitmap = BitmapFactory.decodeStream(is);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        4.网络流
//        bitmap = BitmapFactory.decodeStream(is);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        this.canvas = canvas;

//        method_01();
//        method_02();
        method_03();
    }

    private void method_03() {
        Rect src = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight() / 2);
        Rect dst = new Rect(0, 0, bitmap.getWidth() / 4, bitmap.getHeight() / 4);
        canvas.drawBitmap(bitmap, src, dst, paint);
    }

    private void method_02() {
        canvas.drawBitmap(bitmap, 200, 200, paint);
    }

    private void method_01() {
        canvas.drawBitmap(bitmap, new Matrix(), paint);
    }
}