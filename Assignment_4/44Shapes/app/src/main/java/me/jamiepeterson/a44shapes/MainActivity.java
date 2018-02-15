package me.jamiepeterson.a44shapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private Game game;
    private GameView gameView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        game = new Game();
        gameView = new GameView(this, game);

        setContentView(gameView);

        Timer timer = new Timer();
        GameTimerTask task = new GameTimerTask(game, gameView);
        timer.schedule(task, 0, 20);
    }
}
