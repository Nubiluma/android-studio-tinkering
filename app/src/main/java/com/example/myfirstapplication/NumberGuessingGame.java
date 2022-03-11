package com.example.myfirstapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class NumberGuessingGame extends AppCompatActivity {

    private final Random random = new Random();
    private final int max = 100;
    private int number;
    private int input;
    private int tries = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_guessing_game);
        TextView t = findViewById(R.id.description);
        t.setText("Guess a number between 1 and " + max);
        number = generateRandomNumber();
    }

    private int generateRandomNumber() {
        return random.nextInt(max) + 1; //starting with "1" instead of "0"
    }

    /**
     * Tells player whether guessed number is correct, higher or lower
     */
    private void feedback() {

        TextView t = findViewById(R.id.feedback);

        if (input == number) {
            t.setText("You found the right number!");
        } else if (input < number) {
            t.setText("The number is higher than " + input);
        } else {
            t.setText("The number is lower than " + input);
        }

    }

    /**
     * Requests player to input a number
     */
    public void input(View view) {

        EditText t = findViewById(R.id.editTextNumber);
        input = Integer.parseInt(t.getText().toString());
        tries += 1;
        printTries();
        feedback();
    }

    private void printTries() {
        TextView t = findViewById(R.id.tries);
        t.setText("Tries: " + tries);
    }

}