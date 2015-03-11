package com.example.katotakashi.action;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
/**
 * Created by KATOtakashi on 2015/03/10.
 */
public class Droid {
    private static final float GRAVITY = 0.8f;
    private static final float WEIGHT = GRAVITY * 60;
    private float acceleration = 0;

    public void jump(float power){
        acceleration = power * WEIGHT;
    }

    private final Paint paint = new Paint();
    private Bitmap bitmap;
    final Rect rect;
    private final Callback callback;


    public interface Callback{
        public int getDistanceFromGround(Droid droid);
    }


    public Droid(Bitmap bitmap, int left, int top, Callback callback){
        this.rect = new Rect(left, top, left + bitmap.getWidth(), top + bitmap.getHeight());
        this.bitmap = bitmap;
        this.callback = callback;
    }

    public void draw(Canvas canvas){
        canvas.drawBitmap(bitmap, rect.left, rect.top, paint);
    }

    public void move(){
        acceleration -= GRAVITY;
        int distanceFromGround = callback.getDistanceFromGround(this);
        if(acceleration <0 && acceleration < -distanceFromGround){
            acceleration = -distanceFromGround;
        }
        rect.offset(0, -Math.round(acceleration)); //下へ
    }



}
