package com.ql.customview.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.PictureDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 绘制尺量图
 */
public class Picture extends View {

    private Paint paint;
    private android.graphics.Picture picture;
    private Canvas canvas;

    public Picture(Context context) {
        this(context, null);
    }

    public Picture(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Picture(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(context);
    }

    private void init(Context context) {
        paint = new Paint();
        paint.setAntiAlias(true);
        picture = new android.graphics.Picture();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        this.canvas = canvas;

//        1000传递的是Picture的宽高,即getWidth()/getHeight()获取到的值
        canvas = picture.beginRecording(1000, 1000);

        canvas.drawCircle(500, 500, 400, paint);

        picture.endRecording();

//        Picture_draw();
//        Canvas_drawPicture();
        PictureDrawable_draw();
    }

    /**
     * PictureDrawable的draw方法
     */
    private void PictureDrawable_draw() {
        PictureDrawable pictureDrawable = new PictureDrawable(picture);
//        pictureDrawable.setBounds(100, 100, 1000, 1000);
//        显示部分
        pictureDrawable.setBounds(0, 0, 300, 300);
        pictureDrawable.draw(canvas);
    }

    /**
     * Canvas的drawPicture方法
     */
    private void Canvas_drawPicture() {
//        canvas.drawPicture(picture);
//        缩略
        canvas.drawPicture(picture, new Rect(200, 200, picture.getWidth() + 100, 300));
    }

    /**
     * Picture的draw方法(此方法绘制后可能会影响Canvas状态,不建议使用.)
     */
    private void Picture_draw() {
        picture.draw(canvas);
    }
}
