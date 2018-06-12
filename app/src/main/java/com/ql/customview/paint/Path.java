package com.ql.customview.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/**
 * Author: ql
 * Date: 2018/6/12
 * Desc: Path用法
 * 1.移动起点
 * moveTo(float x, float y) 不改变path
 * setLastPoint(float dx, float dy) 改变path
 * 2.直线
 * lineTo(float x, float y)
 * 3.close
 * 4.贝塞尔曲线
 * quadTo(float x1, float y1, float x2, float y2)   二次
 * cubicTo(float x1, float y1, float x2, float y2, float x3, float y3)  三次
 * 5.基本集合图形
 * 圆
 * addCircle(float x, float y, float radius, Path.Direction dir)
 * 椭圆
 * addOval(float left, float top, float right, float bottom, Direction dir)
 * 矩形
 * addRect(float left, float top, float right, float bottom, Direction dir)
 * 圆角矩形
 * addRoundRect(float left, float top, float right, float bottom, float rx, float ry, Direction dir)
 * 圆弧
 * addArc(float left, float top, float right, float bottom, float startAngle, float sweepAngle)    和上一次操作点无关
 * arcTo(float left, float top, float right, float bottom, float startAngle, float sweepAngle, boolean forceMoveTo)    如果圆弧的起点和上次操作点坐标不同就连接两个点
 * 6.添加一个Path
 * addPath(Path src, float dx, float dy)
 * 7.平移
 * offset(float dx, float dy)
 * 8.设置填充方式
 * setFillType(FillType ft)
 * 9.判断
 * 判空
 * isEmpty()
 * 是否是矩形
 * isRect(RectF rect)
 * 10.赋值
 * set(Path src)
 * 11.重置
 * reset()
 */
public class Path extends View {

    private Paint paint;
    private android.graphics.Path path;
    private WindowManager windowManager;
    private DisplayMetrics displayMetrics;
    private Canvas canvas;

    public Path(Context context) {
        this(context, null);
    }


    public Path(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public Path(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    private void init(Context context) {
        paint = new Paint();
        path = new android.graphics.Path();
        windowManager = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE));
        displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        this.canvas = canvas;

        drawGrid();

//        lineTo();
//        quadTo();
//        cubicTo();
//        addGraphicsPrimitives();
//        addPath();
//        offSet();
        fillType();
    }

    private void fillType() {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(1F);

        path.reset();
        path.addCircle(300, 300, 200, android.graphics.Path.Direction.CW);
        path.addCircle(600, 300, 200, android.graphics.Path.Direction.CW);
        path.setFillType(android.graphics.Path.FillType.INVERSE_EVEN_ODD);
        canvas.drawPath(path, paint);
    }

    private void offSet() {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5F);

        path.reset();
        path.addCircle(300, 300, 200, android.graphics.Path.Direction.CW);
        path.offset(300, 100);
        canvas.drawPath(path, paint);
    }

    private void addPath() {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5F);

        path.reset();
        path.addCircle(300, 300, 100, android.graphics.Path.Direction.CW);
        android.graphics.Path path1 = new android.graphics.Path();
        path1.addRect(200, 400, 400, 500, android.graphics.Path.Direction.CW);
        path.addPath(path1, 100, 0);
        canvas.drawPath(path, paint);
    }

    private void addGraphicsPrimitives() {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5F);

        path.reset();
        path.addCircle(200, 100, 100, android.graphics.Path.Direction.CW);
        path.addRect(400, 100, 600, 200, android.graphics.Path.Direction.CW);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            path.addOval(700, 200, 1000, 400, android.graphics.Path.Direction.CCW);
            path.addRoundRect(100, 500, 500, 300, 100, 100, android.graphics.Path.Direction.CW);
        }
//        path.addArc(new RectF(200, 700, 600, 900), 0, 180);
        path.arcTo(new RectF(200, 700, 600, 900), 0, 180, false);
        canvas.drawPath(path, paint);
    }

    private void cubicTo() {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5F);

        path.reset();
        path.moveTo(0, 0);
        path.cubicTo(300, 100, 200, 600, 700, 700);
        canvas.drawPath(path, paint);
    }

    private void quadTo() {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5F);

        path.reset();
        path.moveTo(100, 400);
        path.quadTo(300, 100, 400, 400);
        canvas.drawPath(path, paint);
    }

    private void lineTo() {
        paint.reset();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setColor(getResources().getColor(android.R.color.holo_green_light));
        paint.setStrokeWidth(10F);

        path.reset();
        path.moveTo(100, 100);
        path.lineTo(400, 100);
        path.lineTo(400, 500);
        path.close();

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