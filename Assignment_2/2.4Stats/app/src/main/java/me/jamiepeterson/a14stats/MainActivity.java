package me.jamiepeterson.a14stats;

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

        //Buttons
        Button button = (Button)findViewById(R.id.b1);
        Sum sum = new Sum();
        button.setOnClickListener(sum);
        button = (Button)findViewById(R.id.b2);
        Mean mean = new Mean();
        button.setOnClickListener(mean);
        button = (Button)findViewById(R.id.b3);
        Median median = new Median();
        button.setOnClickListener(mean);
        button = (Button)findViewById(R.id.b4);
        Stdev stdev = new Stdev();
        button.setOnClickListener(stdev);
        button = (Button)findViewById(R.id.b5);
        Min min = new Min();
        button.setOnClickListener(min);
        button = (Button)findViewById(R.id.b6);
        Max max = new Max();
        button.setOnClickListener(max);
    }

    //On Click Listeners
    private class Sum implements View.OnClickListener{
        public void onClick(View v){
            inputHandler(0);
        }
    }

    private class Mean implements View.OnClickListener{
        public void onClick(View view) {
            inputHandler(1);
        }
    }

    private class Median implements View.OnClickListener{
        public void onClick(View view) {
            inputHandler(2);
        }
    }

    private class Stdev implements View.OnClickListener{
        public void onClick(View view) {
            inputHandler(3);
        }
    }

    private class Min implements View.OnClickListener{
        public void onClick(View view) {
            inputHandler(4);
        }
    }
    private class Max implements View.OnClickListener{
        public void onClick(View view) {
            inputHandler(5);
        }
    }
    //Handles input
    protected void inputHandler(int operation){
        //Get input
        EditText inputText = (EditText)findViewById(R.id.input);
        String inputString = inputText.getText().toString();
        String[] splitInput = inputString.split("\\s+");
        int[] inputArray = new int[splitInput.length];
        for(int i = 0; i < splitInput.length; i++)
            inputArray[i] = Integer.parseInt(splitInput[i]);

        //Send to model
        Stats stat = new Stats(inputArray, operation);

        //Get output
        TextView output = (TextView)findViewById(R.id.output);
        output.setText(""+stat.getSolution());


    }
}
