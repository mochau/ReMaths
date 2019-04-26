package com.example.t_micha.remaths;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

public class instruction extends AppCompatActivity {

    CountDownTimer td;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        new MathAPI().execute();
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //hide title bar
        getSupportActionBar().hide(); // hide title bar
        setContentView(R.layout.activity_instruction);
        ((TextView) findViewById(R.id.tv_inst2)).setText("Topic:\n\nDifficulty:\n\nQuestions:\n\nTime:");
        ((TextView) findViewById(R.id.tv_inst)).setText(MathAPI.topic + "\n\n" + MathAPI.difficulty.substring(0, 1).toUpperCase() + MathAPI.difficulty.substring(1) + "\n\n" + "5\n\n15 seconds");
        td = new CountDownTimer(3000, 1000) {
            public void onTick(long millisUntilFinished) {
                findViewById(R.id.bt_inst_next).setVisibility(View.GONE);
            }
            public void onFinish() {
                findViewById(R.id.bt_inst_next).setVisibility(View.VISIBLE);
            }
        }.start();
    }

    public void launchMathQuestion(View view) {
        Intent intent = new Intent(this, MathQuestion.class);
        String message = ((EditText) findViewById(R.id.et_name)).getText().toString();
        intent.putExtra("NAME_MESSAGE", message);
        startActivity(intent);
    }
}
