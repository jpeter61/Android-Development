package me.jamiepeterson.a33encryption;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    protected static int key;
    protected static SharedPreferences settings;
    private Encryption e;
    private EditText textBox;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e = new Encryption();
        textBox = (EditText)findViewById(R.id.textBox);
        settings = getSharedPreferences("Keys", 0);
        key = settings.getInt("key", 0);
    }

    public void encrypt(View view){
        textBox.setText(e.encrypt(textBox.getText().toString(), key));
    }

    public void decrypt(View view){
        textBox.setText(e.decrypt(textBox.getText().toString(), key));
    }

    public void key(View view){
        Intent intent =  new Intent(this, Key.class);
        startActivity(intent);
    }
}
