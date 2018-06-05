package com.ql.customview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class PaintTest extends View {
    Paint mPaint = new Paint();
    BitmapDrawable bitmapDrawable = (BitmapDrawable) getResources().getDrawable(R.mipmap.test_01);
    Bitmap bitmap = bitmapDrawable.getBitmap();
    BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

    Matrix matrix = new Matrix();
    float scale = Math.max(bitmap.getWidth(), bitmap.getHeight()) * 1.0f / Math.min(bitmap.getWidth(), bitmap.getHeight());


    public PaintTest(Context context) {
        this(context, null);
    }


    public PaintTest(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PaintTest(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        mPaint.setShader(bitmapShader);

        Log.d("QAQ", String.valueOf(bitmap.getHeight()));


        matrix.setScale(scale, scale);
        bitmapShader.setLocalMatrix(matrix);


        canvas.drawCircle(bitmap.getWidth() / 2, bitmap.getHeight() / 2, bitmap.getHeight() / 2, mPaint);
    }
}