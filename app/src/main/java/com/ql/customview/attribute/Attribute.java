package com.ql.customview.attribute;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.ql.customview.R;

/**
 * Author: ql
 * Date: 2018/6/12
 * Desc: 属性获取
 * 1.遍历第二个参数attrs
 * attrs.getAttributeName(i)
 * attrs.getAttributeValue(i)
 * 2.使用TypedArray   用这个!
 * typedArray = context.obtainStyledAttributes(attrs, R.styleable.Attribute, defStyleAttr, 0) --> attr = typedArray.getIndex(i) --> switch... --> typedArray.recycle()
 * <p>
 * 属性值定义的优先级：xml > style > Theme中的默认style > 默认style（第四个参数）> 在Theme中直接指定属性值
 */
public class Attribute extends View {
    private static final String TAG = Attribute.class.getSimpleName();

    private TypedArray typedArray;
    private int color;
    private String text;

    public Attribute(Context context) {
        this(context, null);
    }

    public Attribute(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Attribute(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attrs, int defStyleAttr) {
//        直接使用attrs
        for (int i = 0; i < attrs.getAttributeCount(); i++) {
            Log.d(TAG, attrs.getAttributeName(i) + " = " + attrs.getAttributeValue(i));
        }

//        使用TypedArray
        typedArray = context.obtainStyledAttributes(attrs, R.styleable.Attribute, defStyleAttr, 0);

        for (int i = 0; i < typedArray.getIndexCount(); i++) {
            int attr = typedArray.getIndex(i);
            switch (attr) {
                case R.styleable.Attribute_color:
                    color = typedArray.getColor(R.styleable.Attribute_color, Color.BLACK);
                    break;
                case R.styleable.Attribute_text:
                    text = typedArray.getString(R.styleable.Attribute_text);
                    break;
                case R.styleable.Attribute_dimen:
                    break;
                case R.styleable.Attribute_android_text:
                    break;
            }
        }
        typedArray.recycle();
    }
}