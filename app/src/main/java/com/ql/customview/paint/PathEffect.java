package com.ql.customview.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.DiscretePathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/**
 * Author: ql
 * Date: 2018/6/12
 * Desc: Path效果
 * 1.圆角
 * new CornerPathEffect(float radius) --> paint.setPathEffect(cornerPathEffect)
 * 2.虚线
 * new DashPathEffect(float intervals[], float phase) --> paint.setPathEffect(dashPathEffect)
 * 3.打散
 * new DiscretePathEffect(float segmentLength, float deviation) --> paint.setPathEffect(discretePathEffect)
 * 4.叠加(重合)
 * new SumPathEffect(PathEffect first, PathEffect second) --> paint.setPathEffect(sumPathEffect)
 * 5.混合
 * new ComposePathEffect(PathEffect outerpe, PathEffect innerpe) --> paint.setPathEffect(composePathEffect)
 * 6.Path生成的图形为基本单元的虚线效果
 * new PathDashPathEffect(Path shape, float advance, float phase, Style style) --> paint.setPathEffect(pathDashPathEffect)
 */
public class PathEffect extends View {

    private Paint paint;
    private Path path;
    private Canvas canvas;
    private WindowManager windowManager;
    private DisplayMetrics displayMetrics;
    private float phase = 0;

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
//        discrete();
//        sum();
//        compose();
        pathDash();
    }

    private void pathDash() {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.STROKE);

        path.reset();
        path.moveTo(100, 100);
        path.lineTo(300, 300);
        path.lineTo(500, 400);
        path.lineTo(700, 600);
        path.lineTo(1000, 1500);


        Path path1 = new Path();
        path1.addRect(0, 0, 30, 30, Path.Direction.CW);
        PathDashPathEffect pathDashPathEffect = new PathDashPathEffect(path1, 50, phase, PathDashPathEffect.Style.ROTATE);
        paint.setPathEffect(pathDashPathEffect);
        canvas.drawPath(path, paint);

        phase++;
        invalidate();
    }

    private void compose() {
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

        CornerPathEffect cornerPathEffect = new CornerPathEffect(100);
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{50, 50}, 0);
        ComposePathEffect composePathEffect = new ComposePathEffect(dashPathEffect, cornerPathEffect);
        paint.setPathEffect(composePathEffect);
        canvas.drawPath(path, paint);
    }

    private void sum() {
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

        CornerPathEffect cornerPathEffect = new CornerPathEffect(100);
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{50, 50}, 0);
        SumPathEffect sumPathEffect = new SumPathEffect(dashPathEffect, cornerPathEffect);
        paint.setPathEffect(sumPathEffect);
        canvas.drawPath(path, paint);
    }


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

        DiscretePathEffect discretePathEffect = new DiscretePathEffect(100, 50);
        paint.setPathEffect(discretePathEffect);

        canvas.drawPath(path, paint);
    }

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
    }

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