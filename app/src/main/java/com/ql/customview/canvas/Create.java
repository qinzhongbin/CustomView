package com.ql.customview.canvas;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import com.ql.customview.R;

/**
 * Author: ql
 * Date: 2018/6/12
 * Desc: 构建方法
 * 1.new Canvas()
 * 2.new Canvas(Bitmap bitmap)
 * 3.通过SurfaceView (SurfaceView有单独的绘图缓冲线程, 适用于刷新频率高的情况.)
 * new SurfaceView(Context context) --> holder = surfaceView.getHolder() --> canvas = holder.lockCanvas() --> canvas... --> holder.unlockCanvasAndPost(canvas)
 * 4.重写onDraw()获取
 */
public class Create extends View {

    private Canvas canvas;

    public Create(Context context) {
        this(context, null);
    }

    public Create(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Create(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    private void init(Context context) {
        canvas = new Canvas();

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test_04);
        canvas = new Canvas(bitmap);

        SurfaceView surfaceView = new SurfaceView(context);
        SurfaceHolder holder = surfaceView.getHolder();
        canvas = holder.lockCanvas();
        holder.unlockCanvasAndPost(canvas);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        this.canvas = canvas;
    }
}
