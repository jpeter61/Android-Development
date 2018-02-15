package me.jamiepeterson.a32collegecost;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;


public class FiveActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five);

        TextView credits = (TextView)findViewById(R.id.creditsOut);
        TextView level = (TextView)findViewById(R.id.levelOut);
        TextView dorm = (TextView)findViewById(R.id.dormOut);
        TextView dining = (TextView)findViewById(R.id.diningOut);
        TextView total = (TextView)findViewById(R.id.total);

        credits.setText(""+MainActivity.sc.getCredits());
        level.setText(MainActivity.sc.getLevel());
        if (MainActivity.sc.isDorm())
            dorm.setText("Yes");
        else
            dorm.setText("No");
        if (MainActivity.sc.isDining())
            dining.setText("Yes");
        else
            dining.setText("No");
        total.setText("$"+MainActivity.sc.getCost());



        BackButton bb = new BackButton();
        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(bb);
    }


    public void back(){
        FiveActivity.this.finish();
    }

    private class BackButton implements View.OnClickListener{
        public void onClick(View v){
            back();
        }
    }
}