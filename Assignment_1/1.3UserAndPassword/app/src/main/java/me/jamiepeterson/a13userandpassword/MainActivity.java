package me.jamiepeterson.a13userandpassword;

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
            EditText fname = (EditText)findViewById(R.id.fName);
            EditText lname = (EditText)findViewById(R.id.lName);
            EditText dob = (EditText)findViewById(R.id.dob);

            //Get Strings
            String first = fname.getText().toString();
            String last = lname.getText().toString();
            String date = dob.getText().toString();

            //Create Password and Username
            Password passwordMaker = new Password(first, last, date);

            //Get TextViews
            TextView username = (TextView)findViewById(R.id.user);
            TextView password = (TextView)findViewById(R.id.pass);

            //Output
            username.setText(passwordMaker.getUsername());
            password.setText(passwordMaker.getPassword());
        }
    }

}
