package com.example.myfirstapplication;

import static android.graphics.Color.rgb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //button for opening game activity
        Button gameActivity = (Button) findViewById(R.id.gameActivity);
        gameActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGameActivity();
            }
        });
    }

    /**
     * Method will open class of the game as a new activity
     */
    private void openGameActivity() {
        Intent intent = new Intent(this, NumberGuessingGame.class);
        startActivity(intent);
    }

    //Variant A
    public void disableA(View view) {

        view.setEnabled(false);
        Button buttonA = (Button) findViewById(R.id.button2);
        buttonA.setOnClickListener(this::disableA);
        buttonA.setText("Button A disabled");

    }

    //Variant B
    public void disableB(View view) {

        view.setEnabled(false);
        Button buttonB = (Button) view; //variant 2
        ((Button) view).setText("Button B disabled");
    }

    /**
     * Sets background of view object to a randomly chosen color (rgb value)
     */
    public void toggleRandomColor(View view) {

        view.setBackgroundColor(rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
    }

    /**
     * Lets the user rename textview object through text input
     */
    public void editText(View view){
        EditText t = findViewById(R.id.nameText);
        String input = t.getText().toString();

        TextView v = (TextView) findViewById(R.id.textView1);
        String textView = v.getText().toString();
        v.setText(input);

        //Toast.makeText(this,"edit successful",Toast.LENGTH_LONG).show();
        Toast.makeText(this,"changed '"+ textView + "' to '" + input + "'!",Toast.LENGTH_LONG).show();
    }
}