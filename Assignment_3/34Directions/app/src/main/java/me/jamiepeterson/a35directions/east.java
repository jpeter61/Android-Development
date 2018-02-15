package me.jamiepeterson.a35directions;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class east  extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.east);
    }

    public void back(View view){
        east.this.finish();
        overridePendingTransition(R.anim.main, 0);
    }
}