package me.jamiepeterson.a15tuition;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
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
            //Get EditTexts
            EditText creditsText = (EditText) findViewById(R.id.credits);
            //Get String
            String creditsString = creditsText.getText().toString();
            //Get Int
            int credits;
            try {
                credits = Integer.parseInt(creditsString);
            }
            catch (NumberFormatException e){
                credits = 0;
            }

            //Get Radios
            RadioGroup stateGroup = (RadioGroup) findViewById(R.id.state);
            RadioGroup gradGroup = (RadioGroup) findViewById(R.id.grad);

            //Radio Values
            int stateID = stateGroup.getCheckedRadioButtonId();
            int gradID = gradGroup.getCheckedRadioButtonId();

            //Convert to values
            double state = 1.0;
            int grad = 0;

            //state
            if (stateID == R.id.inState)
                state = 1.0;
            else //If stateID = R.id.outState
                state = 1.5;
            //Grad
            if (gradID == R.id.undergrad)
                grad = 300;
            else if (gradID == R.id.graduate)
                grad = 400;
            else    //if gradID == R.id.nonDegree
                grad = 200;

            //Get checkboxes
            CheckBox dormBox = (CheckBox) findViewById(R.id.dorm);
            CheckBox foodBox = (CheckBox) findViewById(R.id.food);
            CheckBox parkBox = (CheckBox) findViewById(R.id.park);

            //Calculate other value
            int otherVal = 0;
            if (dormBox.isChecked())
                otherVal += 1000;
            if (foodBox.isChecked())
                otherVal += 500;
            if (parkBox.isChecked())
                otherVal += 100;
            //Calculate and output
            Calculate c = new Calculate(credits,state,grad,otherVal);
            TextView output = (TextView)findViewById(R.id.output);
            output.setText("$" + c.getValue());
        }
    }
}
