package me.jamiepeterson.a21gradingtable;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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

    private class ButtonHandler implements View.OnClickListener{
        public void onClick(View v){
            //Toast Stuff
            Context context = getApplicationContext();
            int toastD = Toast.LENGTH_SHORT;
            //Get Assignment
            EditText assignmentText = (EditText) findViewById(R.id.assignmentInput);
            String assignmentString = assignmentText.getText().toString();
            int assignment;
            //error catch
            try {
                assignment = Integer.parseInt(assignmentString);
            }
            catch (NumberFormatException e){
                Toast toast = Toast.makeText(context, "No Assignment Grade", toastD);
                toast.show();
                return;
            }
            if(assignment > 200 || assignment < 0){
                Toast toast = Toast.makeText(context, "Invalid Grade", toastD);
                toast.show();
                return;
            }
            //Get midterm
            EditText midtermText = (EditText) findViewById(R.id.midtermInput);
            String midtermString = midtermText.getText().toString();
            int midterm;
            //error catch
            try {
                midterm = Integer.parseInt(midtermString);
            }
            catch (NumberFormatException e){
                Toast toast = Toast.makeText(context, "No Midterm Grade", toastD);
                toast.show();
                return;
            }
            if(midterm > 100 || midterm < 0){
                Toast toast = Toast.makeText(context, "Invalid Midterm Grade", toastD);
                toast.show();
                return;
            }
            //Get final
            EditText finalText = (EditText) findViewById(R.id.finalInput);
            String finalString = finalText.getText().toString();
            int finalGrade;
            //error catch
            try {
                finalGrade = Integer.parseInt(finalString);
            }
            catch (NumberFormatException e){
                Toast toast = Toast.makeText(context, "No Final Grade", toastD);
                toast.show();
                return;
            }
            if(finalGrade > 100 || finalGrade < 0){
                Toast toast = Toast.makeText(context, "Invalid Final Grade", toastD);
                toast.show();
                return;
            }
            //Calculate Grade and Output
            Grade grading = new Grade(assignment, midterm, finalGrade);
            TextView scoreOutput = (TextView)findViewById(R.id.scoreOutput);
            scoreOutput.setText(grading.getScore()+"%");
            TextView gradeOutput = (TextView)findViewById(R.id.letterOutput);
            gradeOutput.setText(grading.getGrade()+"");
        }
    }
}
