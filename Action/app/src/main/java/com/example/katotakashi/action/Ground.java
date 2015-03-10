package com.example.katotakashi.action;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
/**
 * Created by KATOtakashi on 2015/03/10.
 */
public class Ground {
    private final Paint paint = new Paint();
    final Rect rect;

    public Ground(int left, int top, int right, int bottom){
        rect = new Rect(left, top, right, bottom);
        paint.setColor(Color.rgb(153, 76, 0)); //茶色
    }

    public void draw(Canvas canvas){
        canvas.drawRect(rect, paint);
    }
}
