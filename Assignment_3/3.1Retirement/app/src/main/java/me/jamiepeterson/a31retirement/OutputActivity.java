package me.jamiepeterson.a31retirement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;


public class OutputActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.output);

        ButtonHandler bh = new ButtonHandler();
        Button button = (Button)findViewById(R.id.back);
        button.setOnClickListener(bh);

        updateView();
    }

    private class ButtonHandler implements View.OnClickListener{
        public void onClick(View v){
            OutputActivity.this.finish();
        }
    }

    private void updateView(){
        //get extras
        Intent intent = getIntent();
        float p = intent.getFloatExtra("p", 0);
        float a = intent.getFloatExtra("a", 0);
        float n = intent.getFloatExtra("n", 0);
        float r = intent.getFloatExtra("r", 0);
        //Convert rate
        r =(float)(r/100.0);
        //Get table
        TableLayout tl = (TableLayout) findViewById(R.id.output);
        //dp
        final int DP = (int)(getResources().getDisplayMetrics().density);

        for(int i = 1; i <= n; i++){
            //calculate current
            int amount = (int)(((p+(a/r))*((float)Math.pow((1.0+r),(double)i))-(a/r)));
            //Create row
            TableRow row = new TableRow(this);

            //create label
            TextView label = new TextView(this);
            label.setText("Year "+i);
            label.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
            TableRow.LayoutParams params = new TableRow.LayoutParams(0,0);
            params.width = 50*DP;
            params.height = TableLayout.LayoutParams.WRAP_CONTENT;
            row.addView(label);

            //create value
            TextView value = new TextView(this);
            value.setText("$"+amount);
            value.setPadding(10*DP, 10*DP, 10*DP, 10*DP);
            params = new TableRow.LayoutParams(0,0);
            params.width = 50*DP;
            params.height = TableLayout.LayoutParams.WRAP_CONTENT;
            row.addView(value);
            //add row
            tl.addView(row);
        }
    }

}
