package com.example.uvart.a26gasoline;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Calculator calculator;
    AppInterface appInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        calculator = new Calculator();
        appInterface = new AppInterface(this);
        ButtonHandler buttonHandler = new ButtonHandler();
        appInterface.setEventHandlers(buttonHandler);
        setContentView(appInterface);
    }

    private class ButtonHandler implements View.OnClickListener{
        public void onClick(View v){
            float price = appInterface.getPrice();
            int gallons = appInterface.getGallons();
            calculator.setPrice(price);
            calculator.setGallons(gallons);
            appInterface.setCost(calculator.getCost());
        }
    }
}
