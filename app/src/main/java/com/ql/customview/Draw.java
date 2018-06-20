package com.ql.customview;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
/**
 * Author: ql
 * Date: 2018/6/20
 * Desc: Draw过程
 * 参考:https://www.jianshu.com/p/95afeb7c8335
 */
public class Draw extends View {
    public Draw(Context context) {
        this(context, null);
    }

    public Draw(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Draw(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }
}