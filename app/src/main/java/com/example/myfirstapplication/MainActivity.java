package com.example.myfirstapplication;

import static android.graphics.Color.LTGRAY;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.button);
        b.setOnClickListener(this::disable);
    }

    public void toggleColor(View view){

        view.setBackgroundColor(LTGRAY);
    }

    public void disable(View view){

        view.setEnabled(false);
        toggleColor(view);
        b.setText("Button disabled");
    }
}