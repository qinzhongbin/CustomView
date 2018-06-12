package com.ql.customview.canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author: ql
 * Date: 2018/6/12
 * Desc: 画布快照
 * 1.保存当前画布状态(压栈)
 * save()
 * 2.保存某个图层状态(新建一个图层, 并放入特定的栈中. 使用起来非常复杂, 因为图层之间叠加会导致计算量成倍增长, 避免使用.)
 * saveLayer(float left, float top, float right, float bottom, Paint paint)
 * 3.回滚上一次保存的状态
 * restore()
 * 4.回滚指定保存的状态(该位置及以上位置出栈)
 * restoreToCount(int saveCount)
 * 5.获取保存的次数
 * getSaveCount()
 */
public class Snapshot extends View {

    private Paint paint;
    private Canvas canvas;

    public Snapshot(Context context) {
        this(context, null);
    }

    public Snapshot(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Snapshot(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init();
    }

    private void init() {
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        this.canvas = canvas;

//        save();
//        saveLayer();
//        restore();
//        restoreToCount();
        getSaveCount();
    }

    private void getSaveCount() {
        canvas.getSaveCount();
    }

    private void restoreToCount() {
        canvas.restoreToCount(2);
    }

    private void restore() {
        canvas.restore();
    }

    private void saveLayer() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            canvas.saveLayer(0, 0, 500, 500, paint);
        }
    }

    private void save() {
        canvas.save();
    }
}
