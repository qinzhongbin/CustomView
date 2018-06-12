package com.ql.customview.canvas;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author: ql
 * Date: 2018/6/12
 * Desc: 画布变换
 * 1.平移
 * translate(float dx, float dy)
 * 2.缩放(x,y小于0会翻转)
 * scale(float sx, float sy)
 * scale(float sx, float sy, float px, float py)
 * 3.旋转(顺时针)
 * rotate(float degrees)
 * rotate(float degrees, float px, float py)
 * 4.错切
 * skew(float sx, float sy)
 */
public class Transform extends View {

    private Canvas canvas;
    private Paint paint;

    public Transform(Context context) {
        this(context, null);
    }

    public Transform(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Transform(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        paint = new Paint();

        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        this.canvas = canvas;

//        translate();
//        scale();
//        rotate();
        skew();
    }

    private void skew() {
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3F);

        canvas.drawRect(100, 300, 300, 400, paint);

        canvas.skew(1, 0);

        paint.setColor(Color.BLUE);

        canvas.drawRect(100, 300, 300, 400, paint);
    }

    private void rotate() {
//        canvas.rotate(30);

        canvas.rotate(60, 50, 0);

        canvas.drawRect(100, 100, 200, 200, paint);
    }

    private void scale() {
//        canvas.scale(3, 3);

        canvas.scale(2, 2, 300, 300);

        canvas.drawRect(200, 200, 400, 400, paint);
    }

    private void translate() {
        canvas.translate(100, 100);

        canvas.drawRect(0, 0, 300, 200, paint);
    }
}