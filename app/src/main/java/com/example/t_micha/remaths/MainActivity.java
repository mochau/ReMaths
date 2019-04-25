package com.example.t_micha.remaths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;




public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.t_micha.remaths.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new MathAPI().execute();
    }

    public void launchMathQuestion(View view) {
        Intent intent = new Intent(this, MathQuestion.class);
        String message = ((EditText) findViewById(R.id.et_name)).getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void setEasy(View view) {
        MathAPI.difficulty = "beginner";
    }

    public void setMedium(View view) {
        MathAPI.difficulty = "intermediate";
    }

    public void setHard(View view) {
        MathAPI.difficulty = "advanced";
    }

    public void topicSimple(View view) {
        MathAPI.topic = "listSimple";
    }

    public void topicLinearEquation(View view) {
        MathAPI.topic = "listLinearEquations";
    }
}