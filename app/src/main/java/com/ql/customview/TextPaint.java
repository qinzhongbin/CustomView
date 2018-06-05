package com.ql.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class TextPaint extends View {

    private android.text.TextPaint mPaint;

    private String str = "yearξτβбшㄎěǔぬも测试a";

    private float baseline = 100f;
    private float textWidth;
    private float[] floats;

    public TextPaint(Context context) {
        this(context, null);
    }

    public TextPaint(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TextPaint(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        mPaint = new android.text.TextPaint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(getResources().getColor(android.R.color.holo_red_light));
        mPaint.setTextSize(66f);
        mPaint.setStrokeWidth(5f);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            mPaint.setLetterSpacing(1f);
        }
        mPaint.setTextAlign(Paint.Align.CENTER);


        floats = new float[1];
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint.FontMetricsInt fontMetricsInt = mPaint.getFontMetricsInt();
        Log.d("QAQ", fontMetricsInt.toString());

        textWidth = mPaint.measureText(str);
        Log.d("QAQ", String.valueOf(textWidth));

        int i = mPaint.breakText(str, true, 1000f, floats);
        Log.d("QAQ", String.valueOf(i));
        Log.d("QAQ", String.valueOf(floats[0]));

        canvas.drawText(str, 0f, baseline, mPaint);

        mPaint.setStrokeWidth(1f);
//        baseline
        mPaint.setColor(getResources().getColor(android.R.color.holo_green_light));
        canvas.drawLine(0f, baseline, textWidth, baseline, mPaint);

//        accent
        mPaint.setColor(getResources().getColor(android.R.color.holo_blue_bright));
        canvas.drawLine(0f, baseline + fontMetricsInt.ascent, textWidth, baseline + fontMetricsInt.ascent, mPaint);

//        top
        canvas.drawLine(0f, baseline + fontMetricsInt.top, textWidth, baseline + fontMetricsInt.top, mPaint);

//        decent
        mPaint.setColor(getResources().getColor(android.R.color.holo_orange_dark));
        canvas.drawLine(0f, baseline + fontMetricsInt.descent, textWidth, baseline + fontMetricsInt.descent, mPaint);

//       bottom
        canvas.drawLine(0f, baseline + fontMetricsInt.bottom, textWidth, baseline + fontMetricsInt.bottom, mPaint);
    }
}