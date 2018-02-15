package me.jamiepeterson.a41sliding;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.GridLayout;
import android.widget.TextView;

public class Board extends GridLayout {
    private TextView[][] board;

    public Board (Context context, int size, int width){
        super(context);

        board = new TextView[size][size];
        setRowCount(size);
        setColumnCount(size);

        for (int i = 0; i < size; i++)
            for(int j = 0; j < size; j++){
                board[i][j] = new TextView(context);
                board[i][j].setBackgroundColor(Color.parseColor("#D6F8D6"));
                board[i][j].setTextSize((int)(width*0.2));
                board[i][j].setGravity(Gravity.CENTER);
                GridLayout.LayoutParams params = new LayoutParams();
                params.width = width;
                params.height = width;
                params.rowSpec = GridLayout.spec(i, 1);
                params.columnSpec = GridLayout.spec(j, 1);
                params.topMargin = params.bottomMargin = 1;
                params.leftMargin =  params.rightMargin = 1;
                board[i][j].setLayoutParams(params);
                addView(board[i][j]);
            }
    }
    //Update all values
    public void update(int[][] values){
        for(int i = 0; i < board.length; i++)
            for(int j = 0; j<board[0].length; j++)
                board[i][j].setText(""+values[i][j]);
    }
}
