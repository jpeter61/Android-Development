package me.jamiepeterson.a35directions;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class south  extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.south);
    }

    public void back(View view){
        south.this.finish();
        overridePendingTransition(R.anim.main, 0);
    }
}