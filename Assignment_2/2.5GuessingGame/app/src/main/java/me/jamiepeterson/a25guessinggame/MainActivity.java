package me.jamiepeterson.a25guessinggame;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText input;
    TextView guesses;
    TextView feedback;
    Game game;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get Input/Output
        input = (EditText)findViewById(R.id.input);
        guesses = (TextView) findViewById(R.id.guesses);
        feedback = (TextView) findViewById(R.id.response);

        //Button Handler
        Button button = (Button)findViewById(R.id.enter);
        ButtonHandler temp = new ButtonHandler();
        button.setOnClickListener(temp);

        //StartGame for first time
        game = new Game();
        startGame();

    }

    private class ButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            //Toast Stuff
            Context context = getApplicationContext();
            int toastD = Toast.LENGTH_SHORT;
            //Get Price
            String inputString = input.getText().toString();
            int guess;
            //error catch
            try {
                guess = Integer.parseInt(inputString);
            } catch (NumberFormatException e) {
                Toast toast = Toast.makeText(context, "No Entry", toastD);
                toast.show();
                return;
            }
            if (guess <= 0 || guess > 100) {
                Toast toast = Toast.makeText(context, "Invalid Guess", toastD);
                toast.show();
                return;
            }
            //check Guess
            //if win
            if(game.check(guess)){
                endGame(true);
                return;
            }
            //if not win check if out of guesses
            if(game.checkGuesses()){
                endGame(false);
                return;
            }
            //Give feedback
            feedback.setText(game.feedback(guess));
            //update guesses
            guesses.setText(game.getGuesses()+"");
            input.setText("");
        }
    }

    private void startGame(){
        //set/reset
        guesses.setText("8");
        feedback.setText("");
        input.setText("");
        game.newGame();
    }

    private void endGame(boolean win){
        AlertDialog.Builder dialogBox = new AlertDialog.Builder(this);
        if(win){
            dialogBox.setMessage("You Win! Try Again?");
        }
        else{
            dialogBox.setMessage("You Lose! Try Again?");
        }
        DialogBoxListener temp = new DialogBoxListener();
        dialogBox.setPositiveButton("Yes", temp);
        dialogBox.setNegativeButton("No", temp);
        dialogBox.setNeutralButton("Cancel", temp);
        dialogBox.show();
    }

    private class DialogBoxListener implements DialogInterface.OnClickListener{
        public void onClick(DialogInterface dialog, int id){
            if(id == -1){
                startGame();
            }
            else if( id == -1 ){
                MainActivity.this.finish();
            }
        }
    }
}
