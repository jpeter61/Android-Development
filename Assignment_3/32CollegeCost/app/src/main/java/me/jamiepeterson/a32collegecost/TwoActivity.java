package me.jamiepeterson.a32collegecost;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TwoActivity extends AppCompatActivity {
    private EditText inputView;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        inputView = (EditText)findViewById(R.id.credits);
        int credits = MainActivity.sc.getCredits();
        if(credits == 0)
            inputView.setText("");
        else
            inputView.setText(""+credits);

        NextButton nb = new NextButton();
        Button next = (Button)findViewById(R.id.next);
        next.setOnClickListener(nb);

        BackButton bb = new BackButton();
        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(bb);
    }

    private void next(){
        String inputSting = inputView.getText().toString();
        int credits = Integer.parseInt(inputSting);
        MainActivity.sc.setCredits(credits);
        Intent intent = new Intent(this, ThreeActivity.class);
        startActivity(intent);
    }

    public void back(){
        TwoActivity.this.finish();
    }

    private class NextButton implements View.OnClickListener{
        public void onClick(View v){
            next();
        }
    }

    private class BackButton implements View.OnClickListener{
        public void onClick(View v){
            back();
        }
    }
}
