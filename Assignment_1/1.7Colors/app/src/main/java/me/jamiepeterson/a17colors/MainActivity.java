package me.jamiepeterson.a17colors;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Event Listeners
        EditText redText = (EditText)findViewById(R.id.red);
        EditText greenText = (EditText)findViewById(R.id.green);
        EditText blueText = (EditText)findViewById(R.id.blue);
        TextChangeHandler temp = new TextChangeHandler();
        redText.addTextChangedListener(temp);
        greenText.addTextChangedListener(temp);
        blueText.addTextChangedListener(temp);
    }

    private class TextChangeHandler implements TextWatcher{
        @Override
        public void afterTextChanged(Editable editable) {
            changeColor();
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }
    }

    private void changeColor(){
        //Get Edit Texts
        EditText redText = (EditText)findViewById(R.id.red);
        EditText greenText = (EditText)findViewById(R.id.green);
        EditText blueText = (EditText)findViewById(R.id.blue);

        //Get Strings
        String redString = redText.getText().toString();
        String greenString = greenText.getText().toString();
        String blueString = blueText.getText().toString();

        //Get numerical values
        int red;
        int green;
        int blue;
        try{
            red = Integer.parseInt(redString);
        }catch (NumberFormatException e){
            red = 0;
        }
        try{
            green = Integer.parseInt(greenString);
        }catch (NumberFormatException e){
            green = 0;
        }
        try{
            blue = Integer.parseInt(blueString);
        }catch (NumberFormatException e){
            blue = 0;
        }
        //Error Check
        if(red > 255)
            red = 255;
        if(green > 255)
            green = 255;
        if(blue > 255)
            blue = 255;
        //Show Color
        TextView color = (TextView)findViewById(R.id.color);
        color.setBackgroundColor(Color.rgb(red,green,blue));
    }
}
