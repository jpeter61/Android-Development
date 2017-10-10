package me.jamiepeterson.a18mathquiz;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected Questions q;
    protected boolean entered;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Submit
        Button submit = (Button)findViewById(R.id.submit);
        SubmitHandler temp = new SubmitHandler();
        submit.setOnClickListener(temp);

        //Next
        Button next = (Button)findViewById(R.id.next);
        SubmitHandler tempN = new SubmitHandler();
        next.setOnClickListener(tempN);

        //Start Questions
        new Questions();

        entered = false;
        generate();

    }

    //Submit Handler
    private class SubmitHandler implements View.OnClickListener {
        public void onClick(View v) {
            if(!entered){
                check();
                entered = true;
            }
        }
    }

    //Next Handler
    private class NextHandler implements View.OnClickListener {
        public void onClick(View v) {
            if(entered){
                generate();
                entered = false;
            }
        }
    }

    private void check(){
        //Get Answer
        EditText answerText = (EditText)findViewById(R.id.answer);
        String answerString = answerText.getText().toString();
        int answer;
        try{
            answer = Integer.parseInt(answerString);
        }
        catch (NumberFormatException e){
            answer = 0;
        }

        if(q.checkAnswer(answer)){
            TextView feedback = (TextView)findViewById(R.id.feedback);
            feedback.setText("Correct!");
        }else{
            TextView feedback = (TextView)findViewById(R.id.feedback);
            feedback.setText("Incorrect");
        }
        TextView score = (TextView)findViewById(R.id.score);
        score.setText(q.getCorrect() + " / " + q.getQuestions());
    }

    private void generate(){
        q.generate();

        //Get TextViews
        TextView left = (TextView)findViewById(R.id.left);
        TextView operation = (TextView)findViewById(R.id.operation);
        TextView right = (TextView)findViewById(R.id.right);
        EditText answer = (EditText) findViewById(R.id.answer);

        //Set values
        left.setText(""+q.getLeft());
        operation.setText(""+q.getOperation());
        right.setText(""+q.getRight());
        answer.setText("");
        answer.setBackgroundColor(Color.parseColor("#FFFFFF"));
    }
}

