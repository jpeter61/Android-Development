package me.jamiepeterson.a45ballgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    private Game game;
    private GameView gameView;
    private GestureDetector gestureDetector;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = new Game();
        gameView = new GameView(this, game);

        setContentView(gameView);

        Timer timer = new Timer();
        GameTimerTask task = new GameTimerTask(game, gameView);
        timer.schedule(task, 5000, 20 );

        TouchHandler temp = new TouchHandler();
        gestureDetector = new GestureDetector(this, temp);
        gestureDetector.setOnDoubleTapListener(temp);
    }

    public boolean onTouchEvent (MotionEvent event){
        gestureDetector.onTouchEvent(event);
        return true;
    }

    private class TouchHandler extends GestureDetector.SimpleOnGestureListener{
        public boolean onSingleTapConfirmed(MotionEvent event){
            game.fire();
            return true;
        }
    }
}
