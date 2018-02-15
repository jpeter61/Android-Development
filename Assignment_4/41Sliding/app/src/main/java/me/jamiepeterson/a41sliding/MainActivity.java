package me.jamiepeterson.a41sliding;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {
    private static final int SIZE = 3;
    private Game game;
    private AppInterface appInterface;
    private GestureDetector gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Point screenSize = new Point();
        getWindowManager().getDefaultDisplay().getSize(screenSize);

        appInterface = new AppInterface(this, SIZE);

        initializeGame();
        setContentView(appInterface);
        TouchHandler temp = new TouchHandler();
        gestureDetector = new GestureDetector(this, temp);
        gestureDetector.setOnDoubleTapListener(temp);
    }

    private void initializeGame(){
        game = new Game(SIZE);
        update();
    }

    private void update(){
        appInterface.updateBoard(game.getBoard());
    }

    public boolean onTouchEvent (MotionEvent event){
        gestureDetector.onTouchEvent(event);
        return true;
    }
    private class TouchHandler extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            float startX = e1.getX(), startY = e1.getY();
            float endX = e2.getX(), endY = e2.getY();

            //Vertical
            if(Math.abs(startX - endX) < Math.abs(startY - endY)){
                //up
                if(startY > endY)
                    game.move('N');
                //down
                else
                    game.move('S');
            //Horizontal
            } else if (Math.abs(startX - endX) > Math.abs(startY - endY)){
                //right
                if(startX < endX)
                    game.move('E');
                //left
                else
                    game.move('W');
            }
            // else default do nothing
            appInterface.updateBoard(game.getBoard());
            return super.onFling(e1, e2, velocityX, velocityY);
        }
    }
}


