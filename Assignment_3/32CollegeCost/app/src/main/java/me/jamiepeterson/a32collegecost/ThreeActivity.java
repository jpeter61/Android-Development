package me.jamiepeterson.a32collegecost;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ThreeActivity extends AppCompatActivity {
    private RadioButton undergrad;
    private RadioButton grad;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        undergrad = (RadioButton) findViewById(R.id.Undergraduate);
        grad = (RadioButton) findViewById(R.id.Graduate);
        if(MainActivity.sc.getLevel().equals("Undergraduate"))
            undergrad.setChecked(true);
        else if (MainActivity.sc.getLevel().equals("Graduate"))
            grad.setChecked(true);


        NextButton nb = new NextButton();
        Button next = (Button)findViewById(R.id.next);
        next.setOnClickListener(nb);

        BackButton bb = new BackButton();
        Button back = (Button)findViewById(R.id.back);
        back.setOnClickListener(bb);
    }

    private void next(){
        RadioGroup group = (RadioGroup)findViewById(R.id.radioGroup);
        if(group.getCheckedRadioButtonId() == undergrad.getId())
            MainActivity.sc.setLevel("Undergraduate");
        else if (group.getCheckedRadioButtonId() == grad.getId())
            MainActivity.sc.setLevel("Graduate");

        Intent intent = new Intent(this, FourActivity.class);
        startActivity(intent);
    }

    public void back(){
        ThreeActivity.this.finish();
    }

    private class NextButton implements View.OnClickListener{
        public void onClick(View v){
            next();
        }
    }

    private class BackButton implements View.OnClickListener{
        public void onClick(View v){
            back();
        }
    }
}
