package com.example.gaugechartapp;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class CustomGaugeView extends View {

    private Paint paint;
    private int currentValue = 50;
    private final int maxValue = 100;
    private final int minValue = 0;

    public CustomGaugeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        int width = getWidth();
        int height = getHeight();
        int radius = Math.min(width, height) / 2 - 20;
        int centerX = width / 2;
        int centerY = height / 2;

        // Desenha as regiões coloridas
        paint.setColor(Color.GREEN);
        canvas.drawArc(centerX - radius, centerY - radius, centerX + radius, centerY + radius, 180, 60, false, paint);

        paint.setColor(Color.YELLOW);
        canvas.drawArc(centerX - radius, centerY - radius, centerX + radius, centerY + radius, 240, 60, false, paint);

        paint.setColor(Color.RED);
        canvas.drawArc(centerX - radius, centerY - radius, centerX + radius, centerY + radius, 300, 60, false, paint);

        // Desenha o ponteiro
        float angle = 180 + (currentValue - minValue) * 180.0f / (maxValue - minValue);
        double radians = Math.toRadians(angle);
        float pointerX = (float) (centerX + radius * Math.cos(radians));
        float pointerY = (float) (centerY + radius * Math.sin(radians));

        paint.setColor(Color.BLACK);
        canvas.drawLine(centerX, centerY, pointerX, pointerY, paint);
    }

    public void setValue(int value) {
        if (value >= minValue && value <= maxValue) {
            currentValue = value;
            invalidate();
        }
    }

    public int getValue() {
        return currentValue;
    }
}

