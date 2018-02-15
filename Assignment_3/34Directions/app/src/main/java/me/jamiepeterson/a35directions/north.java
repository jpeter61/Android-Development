package me.jamiepeterson.a35directions;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class north  extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.north);
    }

    public void back(View view){
        north.this.finish();
        overridePendingTransition(R.anim.main, 0);
    }
}
