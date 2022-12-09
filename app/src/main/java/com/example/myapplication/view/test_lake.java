package com.example.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import java.util.Random;

public class test_lake extends View {
    private Paint mPaint;
    private float mProgress;
    public test_lake(Context context) {
        this(context, null);
    }
    public test_lake(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public test_lake(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mProgress == 0)
            return; //碎片雨
        mPaint.setColor(Color.parseColor("#a96ecb"));
        mPaint.setStrokeWidth(3);
        Random random = new Random();
        int sx, sy; for (int i = 0; i < 200; i++) {
            sx = random.nextInt(getWidth() + 10);
            sy = random.nextInt(getHeight() + 10);// canvas.drawLine(sx, sy, sx+random.nextInt(5), sy+random.nextInt(5), mPaint);
            canvas.drawCircle(sx, sy, random.nextInt(5) + 1, mPaint);
        } //進度
        mPaint.setColor(Color.parseColor("#6AFFFFFF"));
        mPaint.setStrokeWidth(15);
        float x = mProgress * getWidth();
        for (int i = 0; i < x; i += 30) {
            canvas.drawLine(i - 30, -10, i + 30, getHeight() + 10, mPaint);
        }
    }
    public void setProgress(float progress) {
        this.mProgress = progress;
        invalidate();
    }
}