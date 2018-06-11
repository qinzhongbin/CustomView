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

    /**
     * 创建画布对象
     * @param context 上下文
     */
    private void init(Context context) {
//        1.无参构造
        canvas = new Canvas();
//        2.传一个Bitmap构造
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.test_04);
        canvas = new Canvas(bitmap);
//        3.通过SurfaceView获取
        SurfaceView surfaceView = new SurfaceView(context);
        SurfaceHolder holder = surfaceView.getHolder();
        canvas = holder.lockCanvas();
        holder.unlockCanvasAndPost(canvas);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        4.重写onDraw()获取
        this.canvas = canvas;
    }
}
