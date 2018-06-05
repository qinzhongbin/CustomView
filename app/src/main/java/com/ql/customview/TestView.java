package com.ql.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class TestView extends View {

    public static final String TAG = TestView.class.getSimpleName();

    public TestView(Context context) {
        super(context);
    }


    public TestView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TestView);

//        Log.d(TAG, typedArray.getString(R.styleable.TestView_text));
//        Log.d(TAG, String.valueOf(typedArray.getColor(R.styleable.TestView_color, getResources().getColor(R.color.colorAccent))));

        for (int i = 0; i < attrs.getAttributeCount(); i++) {
            Log.d(TAG, attrs.getAttributeName(i) + " = " + attrs.getAttributeValue(i));
        }

        Log.d(TAG, String.valueOf(typedArray.getColor(R.styleable.TestView_color, 0)));
        Log.d(TAG, typedArray.getString(R.styleable.TestView_text));

        typedArray.recycle();


    }


    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public TestView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}
