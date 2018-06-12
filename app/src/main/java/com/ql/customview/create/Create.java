package com.ql.customview.create;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/**
 * Author: ql
 * Date: 2018/6/12
 * Desc: 构建方法
 * 1.单参构造(代码里直接new)
 * 2.双参构造(XML布局文件)
 * 3.三参构造(系统内部调用)   用这个!
 * 4.四参构造(系统内部调用)   需要API >= Android5.0
 */
public class Create extends View {

    private Paint paint;
    private Path path;
    private WindowManager windowManager;
    private DisplayMetrics displayMetrics;

    public Create(Context context) {
        super(context);
    }

    public Create(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 三参构造
     *
     * @param context      上下文
     * @param attrs        属性集
     * @param defStyleAttr 自定义的style(对attrs中部分attr设置默认值)
     */
    public Create(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    /**
     * 初始化
     * Paint, Path, DisplayMetrics, etc.
     *
     * @param context 上下文
     */
    private void init(Context context) {
        paint = new Paint();
        path = new Path();
        windowManager = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE));
        displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Create(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }
}