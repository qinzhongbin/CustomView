package com.ql.customview.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.ql.customview.R;

public class ColorFilter extends View {

    private Paint paint;
    private Path path;
    private Canvas canvas;
    private ColorMatrix colorMatrix;
    private ColorMatrixColorFilter colorMatrixColorFilter;
    private Bitmap bitmap;
    private float[] src = {
            1f, 0f, 0f, 0f, 50f,
            0f, 1f, 0f, 0f, 50f,
            0f, 0f, 1f, 0f, 50f,
            0f, 0f, 0f, 1f, 50f
    };
    private LightingColorFilter lightingColorFilter;

    public ColorFilter(Context context) {
        this(context, null);
    }


    public ColorFilter(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public ColorFilter(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    /**
     * 初始化
     * @param context 上下文
     */
    private void init(Context context) {
        paint = new Paint();
        path = new Path();

        colorMatrix = new ColorMatrix();
        colorMatrix.set(src);
        colorMatrixColorFilter = new ColorMatrixColorFilter(colorMatrix);

        lightingColorFilter = new LightingColorFilter(0x00FFFF, 0x000000);

        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test_02);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


//        colorMatrix();
        lighting();
    }

    /**
     * 模拟照明效果颜色过滤
     */
    private void lighting() {
        paint.setColorFilter(lightingColorFilter);
        canvas.drawBitmap(bitmap, 0f, 0f, paint);
    }

    /**
     * 颜色矩阵颜色过滤
     */
    private void colorMatrix() {
        paint.setColorFilter(colorMatrixColorFilter);
        canvas.drawBitmap(bitmap, 0f, 0f, paint);
    }
}
