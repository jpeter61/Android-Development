package me.jamiepeterson.a41sliding;


import android.content.Context;
import android.graphics.Color;
import android.widget.GridLayout;
import android.widget.RelativeLayout;


public class AppInterface extends RelativeLayout {

    private Board board;


    public AppInterface(Context context, int size){
        super(context);

        final int DP = (int)(getResources().getDisplayMetrics().density);

        this.setBackgroundColor(Color.parseColor("#55505C"));
        //Game Board
        board = new Board(context, size, 100*DP);
        board.setId(GridLayout.generateViewId());
        LayoutParams params = new LayoutParams(0,0);
        params.width = LayoutParams.WRAP_CONTENT;
        params.height = LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.topMargin = 20*DP;
        board.setLayoutParams(params);
        addView(board);

    }
    //send to board
    public void updateBoard(int[][] boardValues){
        board.update(boardValues);
    }
}

