package com.ql.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class CustomTitleView extends View {

    public static final String TAG = CustomTitleView.class.getSimpleName();


    public CustomTitleView(Context context) {
        this(context, null);
    }


    public CustomTitleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public CustomTitleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTitleView, defStyleAttr, 0);

        String string = typedArray.getString(R.styleable.CustomTitleView_titleText);

        Log.d(TAG, string);

        typedArray.recycle();
    }
}