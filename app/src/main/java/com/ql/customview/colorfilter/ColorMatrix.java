package com.ql.customview.colorfilter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.ql.customview.R;

public class ColorMatrix extends View {

    private Paint mPaint;
    private android.graphics.ColorMatrix mColorMatrix;
    private float[] src = {
            1f, 0f, 0f, 0f, 50f,
            0f, 1f, 0f, 0f, 50f,
            0f, 0f, 1f, 0f, 50f,
            0f, 0f, 0f, 1f, 50f
    };
    private ColorMatrixColorFilter mColorMatrixColorFilter;
    private Bitmap mBitmap;


    public ColorMatrix(Context context) {
        this(context, null);
    }


    public ColorMatrix(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public ColorMatrix(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();

        mColorMatrix = new android.graphics.ColorMatrix();
        mColorMatrix.set(src);
        mColorMatrixColorFilter = new ColorMatrixColorFilter(mColorMatrix);

        mBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test_02);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        mPaint.setColorFilter(mColorMatrixColorFilter);

        canvas.drawBitmap(mBitmap, 0f, 0f, mPaint);

    }
}
