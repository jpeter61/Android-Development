package me.jamiepeterson.a43drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import java.util.ArrayList;

public class GraphicsView extends View {
    private Drawing drawing;
    private Paint paint;

    public GraphicsView(Context context, Drawing drawing){
        super(context);
        this.drawing = drawing;
        this.paint = new Paint();
    }

    public void onDraw(Canvas canvas){
        ArrayList<Point> listOfPoints = drawing.getListOfPoints();
        paint.setStyle(Paint.Style.FILL);
        for (int i = 0; i < listOfPoints.size(); i++){
            Point curr = listOfPoints.get(i);
            paint.setColor(Color.parseColor(curr.getColor()));
            canvas.drawCircle(curr.getX(), curr.getY(), 15, paint);
        }

        paint.setColor(Color.parseColor(drawing.getColor()));
        canvas.drawRect(850,1550 - 220,1000, 1700 -220, paint);
    }
}
