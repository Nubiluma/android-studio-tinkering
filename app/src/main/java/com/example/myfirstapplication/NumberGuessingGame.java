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
    private int tries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_guessing_game);
    }

    /**
     * Method to (re)start the game
     */
    public void startGame(View view) {

        Button button = (Button) findViewById(R.id.gameButton);
        button.setOnClickListener(this::startGame);

        number = generateRandomNumber();
        tries = 0;

        //Toast.makeText(this, "DEBUG - generated number: " + number,Toast.LENGTH_LONG).show();
        Toast.makeText(this, "A number has been generated", Toast.LENGTH_LONG).show();

        TextView d = findViewById(R.id.description);
        d.setText("Guess a number between 1 and " + max);

        EditText e = findViewById(R.id.editTextNumber);
        e.setText("");
        e.setVisibility(View.VISIBLE);

        button.setText("Confirm");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input(findViewById(R.id.gameButton));
            }
        });

    }

    private int generateRandomNumber() {
        return random.nextInt(max) + 1; //starting with "1" instead of "0"
    }

    /**
     * Tells player whether guessed number is correct, higher or lower
     */
    private void feedback() {

        TextView t = findViewById(R.id.feedback);
        t.setEnabled(true);

        if (input == number) {
            t.setText("You found the right number!");
            retry();
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

        EditText e = findViewById(R.id.editTextNumber);
        input = Integer.parseInt(e.getText().toString());
        tries += 1;
        printTries();
        feedback();
    }

    private void printTries() {
        TextView t = findViewById(R.id.tries);
        t.setText("Tries: " + tries);
    }

    /**
     * Lets player restart the game on button click
     */
    private void retry() {
        Button button = (Button) findViewById(R.id.gameButton);
        button.setText("Click to try again");
        EditText e = findViewById(R.id.editTextNumber);
        e.setVisibility(View.INVISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView f = findViewById(R.id.feedback);
                f.setText("");
                TextView t = findViewById(R.id.tries);
                t.setText("");
                startGame(findViewById(R.id.gameButton));
            }
        });
    }
}