package me.jamiepeterson.a44shapes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class GameView extends View {
    private Game game;
    private double screenWidth;
    private double screenHeight;

    public GameView(Context context, Game game){
        super(context);
        this.game = game;
        screenHeight = 1000;
        screenWidth = 1800;
    }

    public void onDraw(Canvas canvas){
        Object[] circles = game.getCircles();
        Object[] squares = game.getSquares();
        Paint paint = new Paint();
        //Background
        paint.setColor(Color.parseColor("#000000"));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0,0,(float)screenWidth, (float)screenHeight, paint);
        //circles
        for (int i = 0; i < circles.length; i ++) {
            Object curr = circles[i];
            paint.setColor(Color.parseColor(curr.getColor()));
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle((float)curr.getX()
                    ,(float)curr.getY(),
                    (float)curr.getSize(), paint);
        }
        //squares
        for (int i = 0; i < squares.length; i ++) {
            Object curr = squares[i];
            paint.setColor(Color.parseColor(curr.getColor()));
            paint.setStyle(Paint.Style.FILL);
            canvas.drawRect((float)curr.getX()-curr.getSize(),
                    (float)curr.getY()-curr.getSize(),
                    (float)curr.getX()+curr.getSize(),
                    (float)curr.getY()+curr.getSize(),
                    paint);
        }

    }
}
