package com.ql.customview.paint;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RadialGradient;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import com.ql.customview.R;

/**
 * Author: ql
 * Date: 2018/6/12
 * Desc: 着色器
 * 1.位图着色器
 * new BitmapShader(Bitmap bitmap, TileMode tileX, TileMode tileY) --> paint.setShader(bitmapShader)
 * 2.线性渐变着色器(颜色)
 * new LinearGradient(float x0, float y0, float x1, float y1, int colors[], float positions[], TileMode tile)
 * 3.放射性渐变着色器(颜色)
 * new RadialGradient(float centerX, float centerY, float radius, int colors[], float stops[], TileMode tileMode) --> paint.setShader(radialGradient)
 * 4.扫描渐变着色器
 * new SweepGradient(float cx, float cy, int colors[], float positions[]) --> paint.setShader(sweepGradient)
 */
public class Shader extends View {
    private Paint paint;
    private Path path;
    private Canvas canvas;
    private Resources resources;
    private Bitmap bitmap;
    private WindowManager windowManager;
    private DisplayMetrics displayMetrics;

    public Shader(Context context) {
        this(context, null);
    }

    public Shader(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Shader(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    private void init(Context context) {
        paint = new Paint();
        path = new android.graphics.Path();
        resources = getResources();
        windowManager = ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE));
        displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        bitmap = BitmapFactory.decodeResource(resources, R.mipmap.test_04);

        Log.d("QAQ", "width = " + bitmap.getWidth() + "\t" + "height = " + bitmap.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        this.canvas = canvas;

//        bitmap();
//        linearGradient();
//        radialGradient();
        sweepGradient();
    }

    private void sweepGradient() {
        SweepGradient sweepGradient = new SweepGradient(500, 500, new int[]{Color.RED, Color.GREEN, Color.BLUE}, new float[]{0.2f, 0.6f, 1.0f});
        paint.setShader(sweepGradient);
        canvas.drawCircle(500, 500, 400, paint);
    }

    private void radialGradient() {
        RadialGradient radialGradient = new RadialGradient(500, 500, 100, new int[]{Color.RED, Color.GREEN}, new float[]{0.3f, 1.0f}, android.graphics.Shader.TileMode.REPEAT);
        paint.setShader(radialGradient);
        canvas.drawRect(300, 300, 700, 700, paint);
    }

    private void linearGradient() {
        LinearGradient linearGradient = new LinearGradient(0, 0, 100, 200, new int[]{Color.RED, Color.GREEN}, new float[]{0.3f, 0.7f}, android.graphics.Shader.TileMode.REPEAT);
        paint.setShader(linearGradient);
        canvas.drawRect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels, paint);
    }

    private void bitmap() {
        BitmapShader bitmapShader = new BitmapShader(bitmap, android.graphics.Shader.TileMode.MIRROR, android.graphics.Shader.TileMode.REPEAT);
        paint.setShader(bitmapShader);
        canvas.drawRect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels, paint);
    }
}