// Many thanks to Furus J and his ScrubsQuiz app on Github.

package com.example.android.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText firstName;
    EditText lastName;
    RadioGroup radio_group_1;
    RadioGroup radio_group_2;
    RadioButton answer1a;
    RadioButton answer1b;
    RadioButton answer1c;
    RadioButton answer2a;
    RadioButton answer2b;
    RadioButton answer2c;
    CheckBox answer3a;
    CheckBox answer3b;
    CheckBox answer3c;
    CheckBox answer3d;
    CheckBox answer3e;
    CheckBox answer3f;
    CheckBox answer3g;
    CheckBox answer5a;
    CheckBox answer5b;
    CheckBox answer5c;
    CheckBox answer5d;
    CheckBox answer5e;
    CheckBox answer5f;
    CheckBox answer5g;
    CheckBox answer5h;
    EditText question4Answer;
    EditText question6Answer;
    String correctQuestion4Answer1;
    String correctQuestion4Answer2;
    String correctQuestion6Answer1;
    String correctQuestion6Answer2;
    String correctQuestion6Answer3;
    Button send;
    Button submit;
    boolean scoreSubmitted;
    Button reset;
    int totalScore;
    TextView summary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        radio_group_1 = findViewById(R.id.radio_group_1);
        radio_group_2 = findViewById(R.id.radio_group_2);
        answer1a = findViewById(R.id.answer1a);
        answer1b = findViewById(R.id.answer1b);
        answer1c = findViewById(R.id.answer1c);
        answer2a = findViewById(R.id.answer2a);
        answer2b = findViewById(R.id.answer2b);
        answer2c = findViewById(R.id.answer2c);
        answer3a = findViewById(R.id.answer3a);
        answer3b = findViewById(R.id.answer3b);
        answer3c = findViewById(R.id.answer3c);
        answer3d = findViewById(R.id.answer3d);
        answer3e = findViewById(R.id.answer3e);
        answer3f = findViewById(R.id.answer3f);
        answer3g = findViewById(R.id.answer3g);
        question4Answer = findViewById(R.id.answer4);
        correctQuestion4Answer1 = "Captain America";
        correctQuestion4Answer2 = "Steve Rogers";
        answer5a = findViewById(R.id.answer5a);
        answer5b = findViewById(R.id.answer5b);
        answer5c = findViewById(R.id.answer5c);
        answer5d = findViewById(R.id.answer5d);
        answer5e = findViewById(R.id.answer5e);
        answer5f = findViewById(R.id.answer5f);
        answer5g = findViewById(R.id.answer5g);
        answer5h = findViewById(R.id.answer5h);
        question6Answer = findViewById(R.id.answer6);
        correctQuestion6Answer1 = "Peter Parker";
        correctQuestion6Answer2 = "Spider-Man";
        correctQuestion6Answer3 = "Spider Man";
        send = findViewById(R.id.send);
        submit = findViewById(R.id.submit);
        scoreSubmitted = false;
        reset = findViewById(R.id.reset);
        totalScore = 0;
        summary = findViewById(R.id.summary);
    }

    /**
     * This method checks if the correct radio buttons and checkboxes are selected and allocates the appropriate score
     */

    public void calculateScore(View view) {
        String name = firstName.getText().toString();
        // This checks if Question 1 and 2 is answered correctly and adds 1 point each
        if (answer1b.isChecked()) {
            totalScore += 1;
        }
        if (answer2c.isChecked()) {
            totalScore += 1;
        }

        // This checks if Question 3 is answered correctly and adds 1 point each
        if (answer3a.isChecked()) {
            totalScore += 1;
        }
        if (answer3g.isChecked()) {
            totalScore += 1;
        }

        // This checks if Question 5 is answered correctly and adds 1 point each
        if (answer5a.isChecked()) {
            totalScore += 1;
        }
        if (answer5c.isChecked()) {
            totalScore += 1;
        }
        if (answer5e.isChecked()) {
            totalScore += 1;
        }
        if (answer5f.isChecked()) {
            totalScore += 1;
        }
        if (answer5g.isChecked()) {
            totalScore += 1;
        }
        if (answer5h.isChecked()) {
            totalScore += 1;
        }

        // This checks if Question 4 is answered correctly and adds 5 points
        String question4Answered = question4Answer.getText().toString();

        if (question4Answered.equals(correctQuestion4Answer1)
                || question4Answered.equals(correctQuestion4Answer1)
                || question4Answered.equals(correctQuestion4Answer2)) {
            totalScore += 5;
        }

        // This checks if Question 6 is answered correctly and adds 6 points
        String question6Answered = question6Answer.getText().toString();

        if (question6Answered.equals(correctQuestion6Answer1)
                || question6Answered.equals(correctQuestion6Answer1)
                || question6Answered.equals(correctQuestion6Answer2)
                || question6Answered.equals(correctQuestion6Answer3)) {
            totalScore += 5;
        }

        displaySummary(totalScore, name);
        scoreSubmitted = true;
        submit.setVisibility(View.INVISIBLE);
        send.setVisibility(View.VISIBLE);
        reset.setVisibility(View.VISIBLE);
        summary.setVisibility(View.VISIBLE);

        Toast.makeText(getApplicationContext(), "Score calculated.", Toast.LENGTH_LONG).show();
    }

    public void displaySummary(int score, String name) {
        String summaryText = name + " you scored " + score + " out of 20.";
        if (totalScore <= 15) {
            summaryText += "\nHit RESET and try again.";
        }
        if (totalScore >= 16) {
            summaryText += "\nWell done!";
        }
        if (totalScore == 20) {
            summaryText += "\nPerfect! Great Work!";
        }
        summary.setText(summaryText);
    }

    /**
     * This method is called when the reset button is clicked
     */

    public void resetScore(View view) {
        // Clears the first and last name EditText fields
        firstName.setText("");
        lastName.setText("");
        // Clears the selected radio buttons for Questions 1 and 2
        radio_group_1.clearCheck();
        radio_group_2.clearCheck();
        // Clears the selected checkboxes for Question 3
        answer3a.setChecked(false);
        answer3b.setChecked(false);
        answer3c.setChecked(false);
        answer3d.setChecked(false);
        answer3e.setChecked(false);
        answer3f.setChecked(false);
        answer3g.setChecked(false);
        // Clears the selected checkboxes for Question 3
        answer5a.setChecked(false);
        answer5b.setChecked(false);
        answer5c.setChecked(false);
        answer5d.setChecked(false);
        answer5e.setChecked(false);
        answer5f.setChecked(false);
        answer5g.setChecked(false);
        answer5h.setChecked(false);
        // Clears the Answer fields for Question 4 and 6
        question4Answer.setText("");
        // Resets the buttons back to initial state
        submit.setVisibility(View.VISIBLE);
        send.setVisibility(View.INVISIBLE);
        reset.setVisibility(View.INVISIBLE);
        // Clears the calculated score and resets the total score back to 0
        scoreSubmitted = false;
        totalScore = 0;
        // Clears the score summary text and set it back to invisible
        summary.setText("");
        summary.setVisibility(View.INVISIBLE);

        Toast.makeText(getApplicationContext(), "Quiz reset", Toast.LENGTH_LONG).show();
    }

    /**
     * This method is called when the send button is clicked
     */

    public void sendSummary(View view) {
        String summaryText = summary.getText().toString();
        String getName = firstName.getText().toString();
        getName += " " + lastName.getText().toString();
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Avengers Quiz Score for " + getName);
        intent.putExtra(Intent.EXTRA_TEXT, summaryText);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("score", totalScore);
        outState.putBoolean("isSubmitted", scoreSubmitted);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String name = firstName.getText().toString();
        scoreSubmitted = savedInstanceState.getBoolean("isSubmitted");
        totalScore = savedInstanceState.getInt("score");
        if (scoreSubmitted) {
            displaySummary(totalScore, name);
            submit.setVisibility(View.INVISIBLE);
            send.setVisibility(View.VISIBLE);
            reset.setVisibility(View.VISIBLE);
        }

    }
}
