package me.jamiepeterson.a29myapp;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private TextToSpeech tts;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ttsInitListener listener = new ttsInitListener();
        tts = new TextToSpeech(this, listener);
        tts.setLanguage(Locale.US);
        //Button
        Button button = (Button)findViewById(R.id.button);
        ButtonHandler temp = new ButtonHandler();
        button.setOnClickListener(temp);
    }

    private class ButtonHandler implements View.OnClickListener {
        public void onClick(View v) {
            //Toast Stuff
            Context context = getApplicationContext();
            int toastD = Toast.LENGTH_SHORT;
            //Get Price
            EditText textBox = (EditText) findViewById(R.id.textBox);
            String textString = textBox.getText().toString();
            //Convert to CharSequence
            CharSequence textChar = textString;
            //Create unique id
            String utteranceID = this.hashCode()+"";
            //Speak
            tts.speak(textChar,TextToSpeech.QUEUE_ADD,null, utteranceID);
            //Show in toast
            Toast toast = Toast.makeText(context, "Text playing, if you can not hear " +
                    "check volume and make sure TTS is enabled", toastD);
            toast.show();

        }
    }
    private class ttsInitListener implements TextToSpeech.OnInitListener{
        public void onInit(int status){
            //No action taken on complete
        }
    }


}
