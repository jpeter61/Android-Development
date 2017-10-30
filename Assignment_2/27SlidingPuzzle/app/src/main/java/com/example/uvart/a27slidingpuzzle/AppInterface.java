package com.example.uvart.a27slidingpuzzle;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class AppInterface extends RelativeLayout {

    private Board board;
    private Board goal;
    private Button N;
    private Button E;
    private Button W;
    private Button S;


    public AppInterface(Context context, int size, View.OnClickListener[] buttonHandlers){
        super(context);

        final int DP = (int)(getResources().getDisplayMetrics().density);

        this.setBackgroundColor(Color.parseColor("#55505C"));
        //Game Board
        board = new Board(context, size, 100*DP);
        board.setId(GridLayout.generateViewId());
        RelativeLayout.LayoutParams params = new LayoutParams(0,0);
        params.width = LayoutParams.WRAP_CONTENT;
        params.height = LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.topMargin = 20*DP;
        board.setLayoutParams(params);
        addView(board);
        //Goal Board
        goal = new Board(context, size, 100*DP);
        goal.setId(GridLayout.generateViewId());
        params = new LayoutParams(0,0);
        params.width = LayoutParams.WRAP_CONTENT;
        params.height = LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.addRule(RelativeLayout.BELOW, board.getId());
        params.topMargin = 20*DP;
        goal.setLayoutParams(params);
        addView(goal);

        //Centerpiece
        TextView centerpiece = new TextView(context);
        centerpiece.setId(TextView.generateViewId());
        params = new LayoutParams(0,0);
        params.height = LayoutParams.WRAP_CONTENT;
        params.width = LayoutParams.WRAP_CONTENT;
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.addRule(RelativeLayout.BELOW, goal.getId());
        params.topMargin = 10*DP;
        centerpiece.setLayoutParams(params);
        addView(centerpiece);

        //Buttons
        //E
        E = new Button(context);
        E.setId(Button.generateViewId());
        E.setText("\\/");
        E.setBackgroundColor(Color.parseColor("#FAF33E"));
        E.setGravity(Gravity.CENTER);
        params = new LayoutParams(0,0);
        params.width = 100*DP;
        params.height = 100*DP;
        params.addRule(RelativeLayout.LEFT_OF, centerpiece.getId());
        params.addRule(RelativeLayout.BELOW, goal.getId());
        params.topMargin = 10*DP;
        params.leftMargin = 10*DP;
        params.rightMargin =10*DP;
        E.setOnClickListener(buttonHandlers[1]);
        E.setLayoutParams(params);
        addView(E);
        //N
        N = new Button(context);
        N.setId(Button.generateViewId());
        N.setText("<");
        N.setBackgroundColor(Color.parseColor("#FAF33E"));
        N.setGravity(Gravity.CENTER);
        params = new LayoutParams(0,0);
        params.width = 100*DP;
        params.height = 100*DP;
        params.addRule(RelativeLayout.LEFT_OF, E.getId());
        params.addRule(RelativeLayout.BELOW, goal.getId());
        params.topMargin = 10*DP;
        N.setOnClickListener(buttonHandlers[0]);
        N.setLayoutParams(params);
        addView(N);
        //S
        S = new Button(context);
        S.setId(Button.generateViewId());
        S.setText(">");
        S.setBackgroundColor(Color.parseColor("#FAF33E"));
        S.setGravity(Gravity.CENTER);
        params = new LayoutParams(0,0);
        params.width = 100*DP;
        params.height = 100*DP;
        params.rightMargin = 10*DP;
        params.addRule(RelativeLayout.RIGHT_OF, centerpiece.getId());
        params.addRule(RelativeLayout.BELOW, goal.getId());
        params.topMargin = 10*DP;
        S.setOnClickListener(buttonHandlers[2]);
        S.setLayoutParams(params);
        addView(S);
        //W
        W = new Button(context);
        W.setId(Button.generateViewId());
        W.setText("/\\");
        W.setBackgroundColor(Color.parseColor("#FAF33E"));
        W.setGravity(Gravity.CENTER);
        params = new LayoutParams(0,0);
        params.width = 100*DP;
        params.height = 100*DP;
        params.addRule(RelativeLayout.RIGHT_OF, S.getId());
        params.addRule(RelativeLayout.BELOW, goal.getId());
        params.topMargin = 10*DP;
        W.setOnClickListener(buttonHandlers[3]);
        W.setLayoutParams(params);
        addView(W);


    }
    //send to board
    public void updateBoard(int[][] boardValues){
        board.update(boardValues);
    }
    //send to goal
    public void updateGoal(int[][] boardValues){
        goal.update(boardValues);
    }
}
