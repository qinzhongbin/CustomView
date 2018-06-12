package com.ql.customview.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author: ql
 * Date: 2018/6/12
 * Desc: 绘制颜色
 * 1.drawColor(int color)
 * 2.drawRGB(int r, int g, int b)
 * 3.drawARGB(int a, int r, int g, int b)
 */
public class Color extends View {

    private Canvas canvas;

    public Color(Context context) {
        this(context, null);
    }

    public Color(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Color(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        this.canvas = canvas;

//        color();
//        rgb();
        argb();
    }

    private void argb() {
        canvas.drawARGB(156, 50, 222, 169);
    }

    private void rgb() {
        canvas.drawRGB(200, 150, 20);
    }

    private void color() {
        canvas.drawColor(android.graphics.Color.BLUE);
    }
}
