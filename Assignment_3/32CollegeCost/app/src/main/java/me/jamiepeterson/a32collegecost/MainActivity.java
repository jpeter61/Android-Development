package me.jamiepeterson.a32collegecost;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static StudentCost sc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sc = new StudentCost();

        NextButton nb = new NextButton();
        Button next = (Button)findViewById(R.id.next);
        next.setOnClickListener(nb);
    }

    private void next(){
        Intent intent = new Intent(this, TwoActivity.class);
        startActivity(intent);
    }

    private class NextButton implements View.OnClickListener{
        public void onClick(View v){
            next();
        }
    }
}
