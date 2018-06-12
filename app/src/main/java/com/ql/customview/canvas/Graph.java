package com.ql.customview.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author: ql
 * Date: 2018/6/12
 * Desc: 绘制基本几何图形
 * 1.点
 * drawPoint(float x, float y, Paint paint)
 * drawPoints(float[] pts, int offset, int count, Paint paint)
 * 2.线
 * drawLine(float startX, float startY, float stopX, float stopY, Paint paint)
 * drawLines(float[] pts, Paint paint)
 * 3.矩形
 * drawRect(float left, float top, float right, float bottom, Paint paint)
 * 4.圆角矩形
 * drawRoundRect(float left, float top, float right, float bottom, float rx, float ry, Paint paint)
 * 5.圆
 * drawCircle(float cx, float cy, float radius, Paint paint)
 * 6.弧
 * drawArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean useCenter, Paint paint)
 */
public class Graph extends View {

    private Canvas canvas;
    private Paint paint;

    public Graph(Context context) {
        this(context, null);
    }

    public Graph(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Graph(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        this.canvas = canvas;

//        point();
//        line();
//        rect();
//        roundRect();
//        circle();
//        arc();
    }

    private void arc() {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawArc(100, 100, 800, 400, 0f, 270f, false, paint);
        }
    }

    private void circle() {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);

        canvas.drawCircle(500, 500, 200, paint);
    }

    private void roundRect() {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GREEN);
        paint.setAntiAlias(true);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.drawRoundRect(100, 100, 600, 400, 50, 50, paint);
        }
    }

    private void rect() {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);

        canvas.drawRect(100, 100, 500, 500, paint);
    }

    private void line() {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10F);
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);

        canvas.drawLine(100, 100, 500, 500, paint);

        canvas.drawLines(new float[]{100, 100, 500, 100, 100, 300, 500, 300}, paint);
    }

    private void point() {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(10F);
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);

        canvas.drawPoint(250, 800, paint);

        canvas.drawPoints(new float[]{100, 100, 200, 200, 300, 300, 400, 400, 500, 500, 600, 600}, 2, 8, paint);
    }
}
