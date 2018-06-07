package com.ql.customview.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

public class PathEffect extends View {

    private Paint paint;
    private Path path;
    private Canvas canvas;
    private WindowManager windowManager;
    private DisplayMetrics displayMetrics;

    public PathEffect(Context context) {
        this(context, null);
    }

    public PathEffect(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathEffect(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    /**
     * 初始化
     *
     * @param context
     */
    private void init(Context context) {
        paint = new Paint();
        path = new Path();
        windowManager = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE));
        displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;

        drawGrid();

//        corner();
//        dash();
        discrete();
    }

    /**
     * 打散
     */
    private void discrete() {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5F);

        path.reset();
        path.moveTo(100, 100);
        path.lineTo(500, 100);
        path.lineTo(500, 500);

//        new DiscretePathEffect()

        canvas.drawPath(path, paint);

    }

    /**
     * 虚线
     */
    private void dash() {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5F);

        path.reset();
        path.moveTo(100, 100);
        path.lineTo(500, 100);
        path.lineTo(500, 500);

        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{50, 50}, 0);
        paint.setPathEffect(dashPathEffect);

        canvas.drawPath(path, paint);

//        动态改变phase,有动画效果.
        // TODO: 2018/6/7 去了解一下 invalidate()
    }

    /**
     * 圆角
     */
    private void corner() {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5F);

        path.reset();
        path.moveTo(100, 100);
        path.lineTo(300, 300);
        path.lineTo(500, 400);
        path.lineTo(700, 600);
        path.lineTo(1000, 1500);

        CornerPathEffect cornerPathEffect = new CornerPathEffect(50F);
        paint.setPathEffect(cornerPathEffect);
        canvas.drawPath(path, paint);
    }

    /**
     * 画网格
     */
    private void drawGrid() {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(getResources().getColor(android.R.color.white));
        paint.setStrokeWidth(1F);

        path.reset();
        int x = displayMetrics.heightPixels / 100;
        for (int i = 0; i < x; i++) {
            path.moveTo(0, (i + 1) * 100);
            path.lineTo(displayMetrics.widthPixels, (i + 1) * 100);
        }
        int y = displayMetrics.widthPixels / 100;
        for (int i = 0; i < y; i++) {
            path.moveTo((i + 1) * 100, 0);
            path.lineTo((i + 1) * 100, displayMetrics.heightPixels);
        }
        canvas.drawPath(path, paint);
    }
}