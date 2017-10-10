package me.jamiepeterson.a12calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Addition Button
        Button addition = (Button)findViewById(R.id.addition);
        AdditionHandler tempA = new AdditionHandler();
        addition.setOnClickListener(tempA);

        //Subtraction Button
        Button subtraction = (Button)findViewById(R.id.subtraction);
        SubtractionHandler tempS = new SubtractionHandler();
        subtraction.setOnClickListener(tempS);

        //Multiplication Button
        Button multiplication = (Button)findViewById(R.id.multiplication);
        MultiplicationHandler tempM = new MultiplicationHandler();
        multiplication.setOnClickListener(tempM);

        //Division Button
        Button division = (Button)findViewById(R.id.division);
        DivisionHandler tempD = new DivisionHandler();
        division.setOnClickListener(tempD);

    }

    //Addition
    private class AdditionHandler implements View.OnClickListener{
       public void onClick(View v){
           //Get EditTexts
           EditText entry1 = (EditText)findViewById(R.id.Entry1);
           EditText entry2 = (EditText)findViewById(R.id.Entry2);

           //Get Strings
           String string1 = entry1.getText().toString();
           String string2 = entry2.getText().toString();

           //Get floats
           float float1 = Float.parseFloat(string1);
           float float2 = Float.parseFloat(string2);

           //Calculate Answer
           float answer = float1 + float2;

           //Get TextView
           TextView output = (TextView)findViewById(R.id.output);

           //Show Answer
           output.setText(answer + "");
       }
    }

    //Subtraction
    private class SubtractionHandler implements View.OnClickListener{
        public void onClick(View v){
            //Get EditTexts
            EditText entry1 = (EditText)findViewById(R.id.Entry1);
            EditText entry2 = (EditText)findViewById(R.id.Entry2);

            //Get Strings
            String string1 = entry1.getText().toString();
            String string2 = entry2.getText().toString();

            //Get floats
            float float1 = Float.parseFloat(string1);
            float float2 = Float.parseFloat(string2);

            //Calculate Answer
            float answer = float1 - float2;

            //Get TextView
            TextView output = (TextView)findViewById(R.id.output);

            //Show Answer
            output.setText(answer + "");
        }
    }

    //Multiplication
    private class MultiplicationHandler implements View.OnClickListener{
        public void onClick(View v){
            //Get EditTexts
            EditText entry1 = (EditText)findViewById(R.id.Entry1);
            EditText entry2 = (EditText)findViewById(R.id.Entry2);

            //Get Strings
            String string1 = entry1.getText().toString();
            String string2 = entry2.getText().toString();

            //Get floats
            float float1 = Float.parseFloat(string1);
            float float2 = Float.parseFloat(string2);

            //Calculate Answer
            float answer = float1 * float2;

            //Get TextView
            TextView output = (TextView)findViewById(R.id.output);

            //Show Answer
            output.setText(answer + "");
        }
    }

    //Division
    private class DivisionHandler implements View.OnClickListener{
        public void onClick(View v){
            //Get EditTexts
            EditText entry1 = (EditText)findViewById(R.id.Entry1);
            EditText entry2 = (EditText)findViewById(R.id.Entry2);

            //Get Strings
            String string1 = entry1.getText().toString();
            String string2 = entry2.getText().toString();

            //Get floats
            float float1 = Float.parseFloat(string1);
            float float2 = Float.parseFloat(string2);

            //Calculate Answer
            float answer = float1 / float2;

            //Get TextView
            TextView output = (TextView)findViewById(R.id.output);

            //Show Answer
            output.setText(answer + "");
        }
    }
}
