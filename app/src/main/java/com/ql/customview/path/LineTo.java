package com.ql.customview.path;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

public class LineTo extends View {


    private Paint paint;
    private Path path;
    private WindowManager windowManager;
    private DisplayMetrics displayMetrics;

    public LineTo(Context context) {
        this(context, null);
    }


    public LineTo(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }


    public LineTo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

//        画网格
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(getResources().getColor(android.R.color.white));
        paint.setStrokeWidth(1F);

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

//        画三角
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
}