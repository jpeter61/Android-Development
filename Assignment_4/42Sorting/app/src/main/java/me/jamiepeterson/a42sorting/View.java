package me.jamiepeterson.a42sorting;

import android.content.Context;
import android.graphics.Color;
import android.util.TypedValue;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class View extends RelativeLayout {
    private TextView[] board;
    private TextView swapsDisplay;

    public View(Context context){
        super(context);

        final int DP = (int)(getResources().getDisplayMetrics().density);
        board = new TextView[10];
        //create first box
        board[0] = new TextView(context);
        board[0].setId(TextView.generateViewId());
        board[0].setTextColor(Color.parseColor("#000000"));
        board[0].setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        board[0].setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        board[0].setGravity(CENTER_HORIZONTAL);
        RelativeLayout.LayoutParams params = new LayoutParams(0,0);
        params.addRule(CENTER_HORIZONTAL);
        params.width = LayoutParams.WRAP_CONTENT;
        params.height = LayoutParams.WRAP_CONTENT;
        params.topMargin = 5*DP;
        board[0].setLayoutParams(params);
        addView(board[0]);
        //Create rest of boxes
        for (int i = 1; i < board.length; i++){
            board[i] = makeBoxes(context, DP, i);
            addView(board[i]);
        }
        //create swaps box
        swapsDisplay = new TextView(context);
        swapsDisplay.setId(TextView.generateViewId());
        swapsDisplay.setTextColor(Color.parseColor("#000000"));
        swapsDisplay.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        swapsDisplay.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        swapsDisplay.setGravity(CENTER_HORIZONTAL);
        params = new LayoutParams(0,0);
        params.addRule(RelativeLayout.BELOW, board[board.length - 1].getId());
        params.addRule(CENTER_HORIZONTAL);
        params.width = LayoutParams.WRAP_CONTENT;
        params.height = LayoutParams.WRAP_CONTENT;
        params.topMargin = 5*DP;
        swapsDisplay.setLayoutParams(params);
        addView(swapsDisplay);
    }

    public void update(int[] array, int pointer, int swaps){
        for (int i = 0; i < board.length; i++){
            board[i].setText(""+array[i]);
            board[i].setBackgroundColor(Color.parseColor("#FFFFFF"));
        }
        board[pointer].setBackgroundColor(Color.parseColor("#d81e5b"));
        board[pointer+1].setBackgroundColor(Color.parseColor("#d81e5b"));
        swapsDisplay.setText("Swaps left: " + swaps);
    }

    private TextView makeBoxes (Context context, int DP, int i){
        TextView box = new TextView(context);
        box.setId(TextView.generateViewId());
        box.setTextColor(Color.parseColor("#000000"));
        box.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        box.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
        box.setGravity(CENTER_HORIZONTAL);
        RelativeLayout.LayoutParams params = new LayoutParams(0,0);
        params.addRule(RelativeLayout.BELOW, board[i-1].getId());
        params.addRule(CENTER_HORIZONTAL);
        params.width = LayoutParams.WRAP_CONTENT;
        params.height = LayoutParams.WRAP_CONTENT;
        params.topMargin = 5*DP;
        box.setLayoutParams(params);
        return box;
    }
}
