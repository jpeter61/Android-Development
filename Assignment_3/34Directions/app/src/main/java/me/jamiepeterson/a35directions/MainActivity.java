package me.jamiepeterson.a35directions;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void northClick(View view){
        Intent intent = new Intent(this, north.class);
        startActivity(intent);
        overridePendingTransition(R.anim.incoming_north, R.anim.outgoing_north);
    }
    public void southClick(View view){
        Intent intent = new Intent(this, south.class);
        startActivity(intent);
        overridePendingTransition(R.anim.incoming_south, R.anim.outgoing_south);
    }
    public void eastClick(View view){
        Intent intent = new Intent(this, east.class);
        startActivity(intent);
        overridePendingTransition(R.anim.incoming_east, R.anim.outgoing_east);
    }
    public void westClick(View view){
        Intent intent = new Intent(this, west.class);
        startActivity(intent);
        overridePendingTransition(R.anim.incoming_west, R.anim.outgoing_west);
    }


}
