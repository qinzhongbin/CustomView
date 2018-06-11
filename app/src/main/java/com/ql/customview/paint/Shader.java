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

    /**
     * 初始化
     *
     * @param context 上下文
     */
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

    /**
     * 扫描渐变
     */
    private void sweepGradient() {
        SweepGradient sweepGradient = new SweepGradient(500, 500, new int[]{Color.RED, Color.GREEN, Color.BLUE}, new float[]{0.2f, 0.6f, 1.0f});
        paint.setShader(sweepGradient);
        canvas.drawCircle(500, 500, 400, paint);
    }

    /**
     * 放射性渐变
     */
    private void radialGradient() {
        RadialGradient radialGradient = new RadialGradient(500, 500, 100, new int[]{Color.RED, Color.GREEN}, new float[]{0.3f, 1.0f}, android.graphics.Shader.TileMode.REPEAT);
        paint.setShader(radialGradient);
        canvas.drawRect(300, 300, 700, 700, paint);
    }

    /**
     * 线性渐变
     */
    private void linearGradient() {
        LinearGradient linearGradient = new LinearGradient(0, 0, 100, 200, new int[]{Color.RED, Color.GREEN}, new float[]{0.3f, 0.7f}, android.graphics.Shader.TileMode.REPEAT);
        paint.setShader(linearGradient);
        canvas.drawRect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels, paint);
    }

    /**
     * 位图着色器
     */
    private void bitmap() {
        BitmapShader bitmapShader = new BitmapShader(bitmap, android.graphics.Shader.TileMode.MIRROR, android.graphics.Shader.TileMode.REPEAT);
        paint.setShader(bitmapShader);
        canvas.drawRect(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels, paint);
    }
}