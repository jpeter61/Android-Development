package me.jamiepeterson.a28sudoku;

import android.content.DialogInterface;
import android.graphics.Point;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

public class MainActivity extends AppCompatActivity {
    AppInterface appInterface;
    Game game;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Start game
        newGame();
    }

    private TextChangeHandler[][] createTextChangeHandlers(){
        TextChangeHandler[][] textChangeHandlers = new TextChangeHandler[9][9];
        for(int i = 0; i < textChangeHandlers.length; i++)
            for(int j = 0; j <textChangeHandlers[0].length; j++)
                textChangeHandlers[i][j] = new TextChangeHandler(i,j);
        return textChangeHandlers;
    }

    private class TextChangeHandler implements TextWatcher{
        private int x;
        private int y;

        public TextChangeHandler(int x, int y){
            this.x = x;
            this.y = y;
        }


        public void afterTextChanged(Editable editable) {
            int value = appInterface.getValue(x, y);
            //error check
            if (value == -1) {
                game.setZero(x, y);
                return;
            }
            else if(value == 0){
                game.setZero(x,y);
                appInterface.setBlank(x,y);
                return;
            }
            else if(value > 9){
                game.setZero(x,y);
                appInterface.setBlank(x,y);
                return;
            }
            //wrong spot
            if(!game.place(x,y, value))
                appInterface.setBlank(x,y);
            //else leave it be
            //check complete
            if(game.checkComplete())
                popup();
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }
    }
    public void popup(){
        AlertDialog.Builder dialogBox = new AlertDialog.Builder(this);
        dialogBox.setMessage("You win! Go again?");

        DialogBoxListener temp = new DialogBoxListener();
        dialogBox.setPositiveButton("Yes", temp);
        dialogBox.setNegativeButton("No", temp);

        dialogBox.show();
    }

    private class DialogBoxListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            switch (i){
                case -1:
                    newGame();
                    break;
                case -2:
                    MainActivity.this.finish();
                    break;
            }
        }
    }

    private void newGame(){
        Point screenSize = new Point();
        getWindowManager().getDefaultDisplay().getSize(screenSize);
        int width = screenSize.x/9;
        Sudoku sudoku = new Sudoku();
        int[][] board = sudoku.generate();
        game = new Game(board);
        appInterface = new AppInterface(this, width,board,
                createTextChangeHandlers());
        setContentView(appInterface);
    }
}
