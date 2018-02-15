package me.jamiepeterson.a35unitconversions;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MediumActivity extends AppCompatActivity {
    private EditText input1;
    private EditText input2;
    private boolean editingFlag;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medium_activity);

        input1 = (EditText)findViewById(R.id.input1);
        input2 = (EditText)findViewById(R.id.input2);
        editingFlag = false;

        Input1Handler i1 = new Input1Handler();
        Input2Handler i2 = new Input2Handler();
        input1.addTextChangedListener(i1);
        input2.addTextChangedListener(i2);

        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(new BackButton());

    }
    private class Input1Handler implements TextWatcher{
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(editingFlag)
                return;
            String input1String = input1.getText().toString();
            double input1Value;
            try {
                input1Value = Double.parseDouble(input1String);
            } catch (NumberFormatException e){
                input1Value = 0.0;
            }
            double value = input1Value * 0.3048;
            value = Math.floor(value * 100)/100;
            editingFlag = true;
            input2.setText(value+"");
            editingFlag = false;
        }
        public void afterTextChanged(Editable editable) {}
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
    }
    private class Input2Handler implements TextWatcher{
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if(editingFlag)
                return;
            String input2String = input2.getText().toString();
            double input2Value;
            try {
                input2Value = Double.parseDouble(input2String);
            } catch (NumberFormatException e){
                input2Value = 0.0;
            }
            double value = input2Value / 0.3048;
            value = Math.floor(value * 100)/100;
            editingFlag = true;
            input1.setText(value+"");
            editingFlag = false;
        }
        public void afterTextChanged(Editable editable) {}
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
    }
    private class BackButton implements View.OnClickListener{
        public void onClick(View view) {
            MediumActivity.this.finish();
        }
    }
}
