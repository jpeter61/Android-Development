package me.jamiepeterson.a44shapes;

import java.util.TimerTask;

public class GameTimerTask extends TimerTask {
    private Game game;
    private GameView gameView;

    public GameTimerTask(Game game, GameView gameView){
        this.game = game;
        this.gameView = gameView;
    }

    public void run(){
        game.move();
        gameView.postInvalidate();
    }
}
