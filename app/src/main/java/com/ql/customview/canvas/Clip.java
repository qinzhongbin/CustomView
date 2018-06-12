package com.ql.customview.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.ql.customview.R;

/**
 * Author: ql
 * Date: 2018/6/12
 * Desc: 画布裁剪
 * 1.裁剪路径
 * clipPath(Path path)
 * clipOutPath(Path path)
 * 2.裁剪矩形
 * clipRect(int left, int top, int right, int bottom)
 * clipOutRect(int left, int top, int right, int bottom)
 */
public class Clip extends View {

    private Paint paint;
    private Canvas canvas;
    private Bitmap bitmap;

    public Clip(Context context) {
        this(context, null);
    }

    public Clip(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Clip(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        paint = new Paint();

        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test_02);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        this.canvas = canvas;

//        path();
        rect();
    }


    private void rect() {
        canvas.drawColor(Color.GRAY);
//        canvas.clipRect(300, 300, 500, 500);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            canvas.clipOutRect(300, 300, 500, 500);
        }
        canvas.drawColor(Color.GREEN);
    }

    private void path() {
        Path path = new Path();
        path.addCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getHeight() / 2, Path.Direction.CW);

//        canvas.clipPath(path);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            canvas.clipOutPath(path);
        }
        canvas.drawBitmap(bitmap, 0, 0, paint);
    }
}