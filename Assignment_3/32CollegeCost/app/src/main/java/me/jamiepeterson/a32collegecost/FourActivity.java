package me.jamiepeterson.a32collegecost;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by Jamie on 11/12/2017.
 */

public class FourActivity extends AppCompatActivity {
    private CheckBox dorm;
    private CheckBox dining;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        dorm = (CheckBox)findViewById(R.id.dorm);
        dorm.setChecked(MainActivity.sc.isDorm());
        dining = (CheckBox)findViewById(R.id.dining);
        dining.setChecked(MainActivity.sc.isDining());


        NextButton nb = new NextButton();
        Button next = (Button)findViewById(R.id.next);
        next.setOnClickListener(nb);

        BackButton bb = new BackButton();
        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(bb);
    }

    private void next(){
        MainActivity.sc.setDorm(dorm.isChecked());
        MainActivity.sc.setDining(dining.isChecked());

        Intent intent = new Intent(this, FiveActivity.class);
        startActivity(intent);
    }

    public void back(){
        FourActivity.this.finish();
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
