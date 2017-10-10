package me.jamiepeterson.a14retirement;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button
        Button button = (Button)findViewById(R.id.submit);
        ButtonHandler temp = new ButtonHandler();
        button.setOnClickListener(temp);
    }

    //Button Handler
    private class ButtonHandler implements View.OnClickListener{
        public void onClick(View v){
            //Get EditTexts
            EditText principleText = (EditText)findViewById(R.id.principle);
            EditText additionText = (EditText)findViewById(R.id.addition);
            EditText yearsText = (EditText)findViewById(R.id.years);
            EditText rateText = (EditText)findViewById(R.id.rate);

            //Get Strings
            String principle = principleText.getText().toString();
            String addition = additionText.getText().toString();
            String years = yearsText.getText().toString();
            String rate = rateText.getText().toString();


            //Get Floats
            Float p = Float.parseFloat(principle);
            Float a = Float.parseFloat(addition);
            Float n = Float.parseFloat(years);
            Float r = Float.parseFloat(rate);

            boolean error = false;
            //Error Check
            if(!(p > (float)0.0)) {
                principleText.setBackgroundColor(Color.parseColor("#FF0000"));
                error = true;
            }
            else
                principleText.setBackgroundColor(Color.parseColor("#FFFFFF"));
            if(!(a > (float)0.0)) {
                additionText.setBackgroundColor(Color.parseColor("#FF0000"));
                error = true;
            }
            else
                additionText.setBackgroundColor(Color.parseColor("#FFFFFF"));
            if(!(n > (float)0.0)) {
                yearsText.setBackgroundColor(Color.parseColor("#FF0000"));
                error = true;
            }
            else
                yearsText.setBackgroundColor(Color.parseColor("#FFFFFF"));
            if(r > (float)100.0) {
                rateText.setBackgroundColor(Color.parseColor("#FF0000"));
                error = true;
            }
            else
                rateText.setBackgroundColor(Color.parseColor("#FFFFFF"));

            if(!error){
                //Calculate
                Retirement s = new Retirement(p,a,n,r);
                //Output
                TextView output = (TextView)findViewById(R.id.output);
                output.setText("$" + s.getAmount());
            }
            //Else Nothing
        }
    }
}
