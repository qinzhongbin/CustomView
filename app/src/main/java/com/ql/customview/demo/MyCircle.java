package com.ql.customview.demo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.ql.customview.R;

/**
 * Author: ql
 * Date: 2018/6/21
 * Desc: 自定义的一个圆
 */
public class MyCircle extends View {

    private Paint paint;

    public MyCircle(Context context) {
        this(context, null);
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyCircle(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs, defStyleAttr);
    }

    /**
     * 初始化
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
        paint = new Paint();

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyCircle, defStyleAttr, 0);
        for (int i = 0; i < typedArray.getIndexCount(); i++) {
            switch (typedArray.getIndex(i)) {
                case R.styleable.MyCircle_circle_color:
                    paint.setColor(typedArray.getColor(R.styleable.MyCircle_circle_color, Color.BLUE));
                    break;
                case R.styleable.MyCircle_attr_2:
                    break;
                case R.styleable.MyCircle_attr_3:
                    break;
                case R.styleable.MyCircle_attr_4:
                    break;
            }
        }
        typedArray.recycle();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();

        int width = getWidth() - paddingLeft - paddingRight;
        int height = getHeight() - paddingTop - paddingBottom;


        int r = Math.min(width, height) / 2;

        canvas.drawCircle(paddingLeft + width / 2, paddingRight + height / 2, r, paint);
    }
}