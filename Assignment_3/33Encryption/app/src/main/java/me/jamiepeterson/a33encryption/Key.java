package me.jamiepeterson.a33encryption;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class Key extends AppCompatActivity {
    private EditText keyText;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_key);
        keyText = (EditText)findViewById(R.id.key);
        keyText.setText(MainActivity.key+"");
    }

    public void submit(View view){
        int newKey;
        try{
            newKey = Integer.parseInt(keyText.getText().toString());
        }catch (NumberFormatException e){
            newKey = 0;
        }
        MainActivity.key = newKey;
        SharedPreferences.Editor editor = MainActivity.settings.edit();
        editor.putInt("key", newKey);
        editor.commit();
        Key.this.finish();
    }
}
