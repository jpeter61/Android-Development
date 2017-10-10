package me.jamiepeterson.a110queens;

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
    private class ButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            //Get Edit Text
            EditText mText = (EditText) findViewById(R.id.m);
            EditText nText = (EditText) findViewById(R.id.n);
            //Get String
            String mString = mText.getText().toString();
            String nString = nText.getText().toString();
            //Get Int
            int m;
            int n;
            try {
                m = Integer.parseInt(mString);
            }
            catch (NumberFormatException e){
                m = 2;
            }
            try {
                n = Integer.parseInt(nString);
            }
            catch (NumberFormatException e){
                n = 2;
            }
            //Get output and final error check
            String output;
            if(n >= m){
                Queens q = new Queens(m,n);
                output = q.solve();
            }
            else
                output = "Make sure input is valid";

            //Display output
            TextView outputBox = (TextView)findViewById(R.id.output);
            outputBox.setText(output);
        }
    }
}
