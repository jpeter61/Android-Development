package me.jamiepeterson.a45ballgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class GameView extends View {
    private Game game;
    private double sceneWidth;
    private double sceneHeight;

    public GameView(Context context, Game game){
        super(context);
        this.game = game;
        this.sceneHeight = 1000;
        this.sceneWidth = 1800;
    }

    public void onDraw (Canvas canvas){
        double ballX = game.getBallX();
        double ballY = game.getBallY();
        double bulletX = game.getBulletX();
        double bulletY = game.getBulletY();
        double gunX = game.getGunX();
        double gunY = game.getGunY();
        double radius = game.getRadius();

        Paint paint = new Paint();
        //Background
        paint.setColor(Color.parseColor("#AAAAAA"));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRect(0,0, (float) sceneWidth, (float) sceneHeight, paint);
        //Ball
        if (!game.isHit()) {
            paint.setColor(Color.parseColor("#004400"));
            paint.setStyle(Paint.Style.FILL);
            canvas.drawCircle((float) ballX, (float) (sceneHeight - ballY), (float) radius, paint);
        }
        //Bullet
        paint.setColor(Color.parseColor("#000000"));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle((float)bulletX, (float)(sceneHeight - bulletY), (float)radius, paint);
        //Gun
        paint.setColor(Color.parseColor("#000000"));
        paint.setStyle(Paint.Style.STROKE);
        paint .setStrokeWidth(30);
        canvas.drawLine(0, (float)sceneHeight, (float)gunX,(float)(sceneHeight - gunY), paint);
    }
}
