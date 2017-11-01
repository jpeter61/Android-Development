package me.jamiepeterson.a28sudoku;

import android.content.Context;
import android.graphics.Color;
import android.text.InputType;
import android.text.TextWatcher;
import android.view.Gravity;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.TextView;


public class
AppInterface extends GridLayout {
    private EditText[][] board;

    public AppInterface(Context context, int width, int[][] values,
                        TextWatcher[][] handlers ){
        super(context);
        setRowCount(9);
        setColumnCount(9);
        //Set background
        this.setBackgroundColor(Color.parseColor("#55505C"));
        //CreateBoard
        board = new EditText[9][9];
        for(int i  = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = new EditText(context);
                board[i][j].setBackgroundColor(
                        Color.parseColor("#D6F8D6"));
                board[i][j].setTextSize((int)(width*0.1));
                board[i][j].setGravity(Gravity.CENTER);
                board[i][j].setInputType(InputType.TYPE_CLASS_NUMBER);
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

        //Set values
        for(int i  = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++){
                //if there is a value
                if(values[i][j]!=0){
                    board[i][j].setText(""+values[i][j]);
                    //Stop input
                    board[i][j].setInputType(InputType.TYPE_NULL);
                    board[i][j].setBackgroundColor(
                            Color.parseColor("#7FC6A4"));
                }
            }

        //Set Listeners
        for(int i  = 0; i < board.length; i++)
            for(int j = 0; j < board[0].length; j++){
                //if there is a value
                if(values[i][j]==0){
                    board[i][j].addTextChangedListener(handlers[i][j]);
                }
            }
    }

    public int getValue(int x, int y){
        String valueString = board[x][y].getText().toString();

        //Prevent infinite loops
        if(valueString.isEmpty()){
            return -1;
        }

        int value;
        try{
            value = Integer.parseInt(valueString);
        }catch (NumberFormatException e){
            value = 0;
        }
        return value;
    }

    public void setBlank(int x, int y){
        board[x][y].setText("");
    }
}
