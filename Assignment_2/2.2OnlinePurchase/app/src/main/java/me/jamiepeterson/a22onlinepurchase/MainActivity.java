package me.jamiepeterson.a22onlinepurchase;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Button
        Button button = (Button)findViewById(R.id.enter);
        ButtonHandler temp = new ButtonHandler();
        button.setOnClickListener(temp);
    }

    private class ButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            //Toast Stuff
            Context context = getApplicationContext();
            int toastD = Toast.LENGTH_SHORT;
            //Get Price
            EditText priceText = (EditText) findViewById(R.id.price);
            String priceString = priceText.getText().toString();
            int price;
            //error catch
            try {
                price = Integer.parseInt(priceString);
            } catch (NumberFormatException e) {
                Toast toast = Toast.makeText(context, "No Price Entered", toastD);
                toast.show();
                return;
            }
            if (price < 0) {
                Toast toast = Toast.makeText(context, "Invalid Price", toastD);
                toast.show();
                return;
            }
            //Get toggle button
            ToggleButton warrantyButton = (ToggleButton)findViewById(R.id.warranty);
            boolean warranty = warrantyButton.isChecked();

            //Get switch
            Switch insuranceSwitch = (Switch) findViewById(R.id.insurance);
            boolean insurance = warrantyButton.isChecked();

            //Get Spinner
            Spinner deliverySpinner = (Spinner) findViewById(R.id.delivery);
            String delivery = (String)deliverySpinner.getSelectedItem();

            //Get Cost
            Cost calculateCost = new Cost(price, warranty, insurance, delivery);
            TextView costOutput = (TextView) findViewById(R.id.cost);
            costOutput.setText("$"+calculateCost.getCost());
        }
    }
}
