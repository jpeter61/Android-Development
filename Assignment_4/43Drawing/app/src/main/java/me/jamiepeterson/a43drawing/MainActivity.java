package me.jamiepeterson.a43drawing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class MainActivity extends AppCompatActivity {
    private Drawing drawing;
    private GraphicsView graphicsView;
    private GestureDetector gestureDetector;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        drawing = new Drawing();
        graphicsView = new GraphicsView(this, drawing);
        setContentView(graphicsView);

        TouchHandler temp =  new TouchHandler();
        gestureDetector = new GestureDetector(this, temp);
        gestureDetector.setOnDoubleTapListener(temp);
    }

    public boolean onTouchEvent(MotionEvent event){
        int x = (int)event.getRawX();
        int y = (int)event.getRawY() - 220;

        int action = event.getAction();

        //if over box
        if (x > 850 && x < 1000 && y > 1550 - 220 && y < 1700 -220){
            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    drawing.cycleColor();
                    break;
                case MotionEvent.ACTION_MOVE:
                    //No Drawing
                    break;
            }
        } else {
            switch (action) {
                case MotionEvent.ACTION_DOWN:
                    drawing.addPoint(x, y);
                    break;
                case MotionEvent.ACTION_MOVE:
                    drawing.addPoint(x, y);
                    break;
            }
        }
        graphicsView.postInvalidate();
        //gestureDetector.onTouchEvent(event);
        return true;
    }

    private class TouchHandler extends GestureDetector.SimpleOnGestureListener{

    }
}
