package com.example.uvart.a27slidingpuzzle;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private static final int SIZE = 3;
    private Game game;
    private AppInterface appInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        Point screenSize = new Point();
        getWindowManager().getDefaultDisplay().getSize(screenSize);
        int width = screenSize.x/SIZE;

        ButtonHandler[] buttonHandlers = makeButtonHandlers();

        appInterface = new AppInterface(this, SIZE, buttonHandlers);

        initializeGame();
        setContentView(appInterface);
    }

    //make button handlers
    private ButtonHandler[] makeButtonHandlers(){
        ButtonHandler[] buttonHandlers = new ButtonHandler[4];
        buttonHandlers[0] = new ButtonHandler('N');
        buttonHandlers[1] = new ButtonHandler('E');
        buttonHandlers[2] = new ButtonHandler('S');
        buttonHandlers[3] = new ButtonHandler('W');

        return buttonHandlers;
    }

    private class ButtonHandler implements View.OnClickListener{
        private char direction;
        public ButtonHandler (char direction){
            this.direction = direction;
        }
        public void onClick(View v){
            if(game.move(direction))
                update();
            //else nothing happens
        }
    }

    private void initializeGame(){
        game = new Game(SIZE);
        update();
        updateGoal();
    }

    private void update(){
        appInterface.updateBoard(game.getBoard());
    }
    private void updateGoal(){
        appInterface.updateGoal(game.getGoal());
    }
}
