package com.ql.customview.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author: ql
 * Date: 2018/6/12
 * Desc: 绘制文字
 * 1.指定开始位置
 * drawText(String text, int start, int end, float x, float y, Paint paint)
 * 2.指定每个文字的位置(不支持表情,已弃用.)
 * drawPosText(char[] text, int index, int count, float[] pos, Paint paint)
 * 3.在path指定的路径上绘制
 * drawTextOnPath(String text, Path path, float hOffset, float vOffset, Paint paint)
 */
public class Text extends View {

    private Paint paint;
    private Canvas canvas;

    public Text(Context context) {
        this(context, null);
    }

    public Text(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Text(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        paint = new Paint();

        paint.setAntiAlias(true);
//        设置文字的属性(大小颜色etc.)
        paint.setColor(Color.GREEN);
        paint.setTextSize(100F);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        this.canvas = canvas;

//        startPosition();
//        eachPosition();
        path();
    }

    private void path() {
        Path path = new Path();
        path.moveTo(100, 100);
        path.quadTo(800, 300, 100, 800);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawPath(path, paint);

        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawTextOnPath("adcdefg", path, 100, 0, paint);
    }

    private void eachPosition() {
        canvas.drawPosText("abcdefg".toCharArray(), 1, 5, new float[]{
                        100, 100,
                        200, 200,
                        300, 300,
                        400, 400,
                        500, 500},
                paint);
    }

    private void startPosition() {
        canvas.drawText("abcdefg", 1, 5, 100, 100, paint);
    }
}
