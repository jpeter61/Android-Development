package me.jamiepeterson.a42sorting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Game game;
    private boolean playing;
    private View view;
    private GestureDetector gestureDetector;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        game = new Game();
        view = new View(this);
        playing = true;
        TouchHandler temp = new TouchHandler();
        gestureDetector = new GestureDetector(this, temp);
        gestureDetector.setOnDoubleTapListener(temp);
        view.update(game.getBoard(), game.getPointer(), game.getSwaps());
        setContentView(view);
    }

    public boolean onTouchEvent(MotionEvent event){
        gestureDetector.onTouchEvent(event);
        return true;
    }

    private void toast(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private class TouchHandler extends GestureDetector.SimpleOnGestureListener{
        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            if (playing){
                game.movePointer();
                //update display
                view.update(game.getBoard(), game.getPointer(), game.getSwaps());
            }
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            if (playing){
                int next = game.swap();
                //update display
                view.update(game.getBoard(), game.getPointer(), game.getSwaps());
                switch (next){
                    case 1: //Winning
                        toast("YOU WON!");
                        playing = false;
                        break;
                    case -1: //lose
                        toast("YOU LOST!");
                        playing = false;
                        break;
                    //nothing happens on 0
                }
            }
            return true;
        }
    }
}
