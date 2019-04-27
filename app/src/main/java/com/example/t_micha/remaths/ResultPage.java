package com.example.t_micha.remaths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class ResultPage extends AppCompatActivity {

    String resultMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //hide title bar
        getSupportActionBar().hide(); // hide title bar
        setContentView(R.layout.activity_result_page);

        //Displays user's final score
        ((TextView) findViewById(R.id.tv_result)).setText("Score: \n" + MathQuestion.score + " / 5");

        //Provides user with feedback based on their score
        if (MathQuestion.score == 0) {
            resultMessage = "Why Maths, " + MathQuestion.userName;
        } else if (MathQuestion.score == 1) {
            resultMessage = "You were Lucky " + MathQuestion.userName;
        } else if (MathQuestion.score == 2) {
            resultMessage = "Could be better " + MathQuestion.userName;
        } else if (MathQuestion.score == 3) {
            resultMessage = "Not bad " + MathQuestion.userName;
        } else if (MathQuestion.score == 4) {
            resultMessage = "Almost there " + MathQuestion.userName;
        } else {
            resultMessage = "Perfect score " + MathQuestion.userName;

        }
        ((TextView) findViewById(R.id.tv_result_string)).setText(resultMessage);
    }

    public void launchSelectionMenuAgain(View view) {
        MathQuestion.score = 0; //Resets score for next round
        MathQuestion.qs_count = 0; //Resets count for next round
        Intent intent = new Intent(this, SelectionMenu.class);
        startActivity(intent);
    }
}
