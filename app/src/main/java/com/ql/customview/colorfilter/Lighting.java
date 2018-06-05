package com.ql.customview.colorfilter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.ql.customview.R;

public class Lighting extends View {

    private Paint mPaint;
    private Bitmap bitmap;

    public Lighting(Context context) {
        this(context, null);
    }


    public Lighting(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public Lighting(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new Paint();

        mPaint.setColorFilter(new LightingColorFilter(0x00FFFF, 0x000000));


        bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test_02);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        canvas.drawBitmap(bitmap, 0f, 0f, mPaint);
    }
}
