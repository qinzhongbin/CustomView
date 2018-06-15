package com.ql.customview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Layout extends View {
    public Layout(Context context) {
        super(context);
    }

    public Layout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Layout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void layout(int l, int t, int r, int b) {
        super.layout(l, t, r, b);
    }


}
