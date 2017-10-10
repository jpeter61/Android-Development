package me.jamiepeterson.a16primenumbers;

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
            EditText primeCountText = (EditText) findViewById(R.id.primeCount);
            //Get String
            String primeCountString = primeCountText.getText().toString();
            //Get Int
            int primeCount;
            try {
                primeCount = Integer.parseInt(primeCountString);
            }
            catch (NumberFormatException e){
                primeCount = 0;
            }
            
            //New Object
            Primes p = new Primes(primeCount);
            //Get output
            TextView output = (TextView)findViewById(R.id.output);
            int[] primes = p.getPrimes();
            String stringPrimes = "";
            for (int i = 0; i < primes.length; i++)
                stringPrimes = stringPrimes + primes[i] + "\n";
            output.setText(stringPrimes);
        }
    }
}
