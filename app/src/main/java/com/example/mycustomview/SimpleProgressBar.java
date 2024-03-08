package com.example.mycustomview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

public class SimpleProgressBar extends View {
    private String tag = "SimpleProgressBar";
    private Paint paint;
    private float progress = 0;


    public SimpleProgressBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
    }

    public float getProgress() {
        return this.progress;
    }

    public void setProgress(float progress) {
        this.progress = progress;
        Log.d(tag, "invalidate() 호출됨: 진행률 변경"); // 로그 문 추가
        invalidate(); // View 다시 그리기 ( 다시 그려야 한다고 알려줌 )
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d(tag, "onAttachedToWindow() 호출됨");
    }


    // measure() : View의 크기를 결정

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 여기서 CustomView의 크기를 결정

        int desiredWidth = 100;
        int desiredHeight = 50;

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;

        // 너비 측정
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            width = Math.min(desiredWidth, widthSize);
        } else {
            width = desiredWidth;
        }

        // 높이 측정
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            height = Math.min(desiredHeight, heightSize);
        } else {
            height = desiredHeight;
        }

        Log.d(tag, String.format("onMeasure() 호출됨: width = %d, height = %d", width, height));
        setMeasuredDimension(width, height);
    }

    // layout() : 뷰의 위치를 결정하는 역할

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        // 일반적으로 CustomView에서는 이 메소드를 구현할 필요가 없습니다.
        // View가 자식 View를 포함하지 않기 때문입니다.
        Log.d(tag, "onLayout() 호출됨");
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Log.d(tag, "dispatchDraw() 호출됨");
    }

    // draw() : 자식 뷰 그리기

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 실제로 View를 그리는 로직
        float width = (getWidth() * progress) / 100;
        canvas.drawRect(0, 0, width, getHeight(), paint);

        Log.d(tag, "onDraw() 호출됨");
    }


}
