package com.example.myfirstapplication;

import static android.graphics.Color.rgb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonA;
    private final Random random = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonA = (Button) findViewById(R.id.button2);
        buttonA.setOnClickListener(this::disableA);
    }

    //Variant A
    public void disableA(View view) {

        view.setEnabled(false);
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
     * @param view
     */
    public void toggleRandomColor(View view) {

        view.setBackgroundColor(rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
    }
}