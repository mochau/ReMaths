package com.example.t_micha.remaths;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.CountDownTimer;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import io.github.kexanie.library.MathView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public int correctResponse;
    CountDownTimer td;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_main);
        onRefresh(null);
    }

    public void onRefresh(View view) {
        MathAPI dummyMathAPI = new MathAPI();
        MathResponse MR = dummyMathAPI.returnMath();
        ((MathView) findViewById(R.id.mv_1)).setText(MR.getChoices().get(0));
        ((MathView) findViewById(R.id.mv_2)).setText(MR.getChoices().get(1));
        ((MathView) findViewById(R.id.mv_3)).setText(MR.getChoices().get(2));
        ((MathView) findViewById(R.id.mv_4)).setText(MR.getChoices().get(3));
        ((MathView) findViewById(R.id.mv_5)).setText(MR.getChoices().get(4));
        ((TextView) findViewById(R.id.bt1)).setText("Q1");
        ((TextView) findViewById(R.id.bt2)).setText("Q2");
        ((TextView) findViewById(R.id.bt3)).setText("Q3");
        ((TextView) findViewById(R.id.bt4)).setText("Q4");
        ((TextView) findViewById(R.id.bt5)).setText("Q5");
        correctResponse = MR.getCorrectChoice();
        ((MathView) findViewById(R.id.mv_qs)).setText("<math>" + MR.getQuestion() + "</math>");

        td = new CountDownTimer(20000, 1000) {

            public void onTick(long millisUntilFinished) {
                ((TextView) findViewById(R.id.tv_timer)).setText("Timer: " + millisUntilFinished / 1000);
                findViewById(R.id.bt1).setEnabled(true);
                findViewById(R.id.bt2).setEnabled(true);
                findViewById(R.id.bt3).setEnabled(true);
                findViewById(R.id.bt4).setEnabled(true);
                findViewById(R.id.bt5).setEnabled(true);
                findViewById(R.id.btRefresh).setVisibility(View.GONE);
            }

            public void onFinish() {
                ((TextView) findViewById(R.id.tv_timer)).setText("Time's Up");
                findViewById(R.id.bt1).setEnabled(false);
                findViewById(R.id.bt2).setEnabled(false);
                findViewById(R.id.bt3).setEnabled(false);
                findViewById(R.id.bt4).setEnabled(false);
                findViewById(R.id.bt5).setEnabled(false);
            }
        }.start();
    }

    private void answerDialog(boolean Answer) {
        td.onFinish();
        td.cancel();
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setCancelable(false);
        if (Answer) {
            dialog.setMessage("Good work");
            dialog.setTitle("Correct");
        } else {
            dialog.setMessage("Please study harder");
            dialog.setTitle("Incorrect");
        }
        dialog.setPositiveButton("next question",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        onRefresh(null);
                    }
                });
        dialog.setNegativeButton("review", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                findViewById(R.id.btRefresh).setVisibility(View.VISIBLE);
            }
        });
        AlertDialog alertDialog = dialog.create();
        alertDialog.show();
    }

    public void onQ1(View view) {
        if (correctResponse == 0) {
            ((TextView) findViewById(R.id.bt1)).setText("Correct!");
        } else {
            ((TextView) findViewById(R.id.bt1)).setText("Incorrect!");
        }
        answerDialog(correctResponse == 0);
    }

    public void onQ2(View view) {
        if (correctResponse == 1) {
            ((TextView) findViewById(R.id.bt2)).setText("Correct!");
        } else {
            ((TextView) findViewById(R.id.bt2)).setText("Incorrect!");
        }
        answerDialog(correctResponse == 1);
    }

    public void onQ3(View view) {
        if (correctResponse == 2) {
            ((TextView) findViewById(R.id.bt3)).setText("Correct!");
        } else {
            ((TextView) findViewById(R.id.bt3)).setText("Incorrect!");
        }
        answerDialog(correctResponse == 2);
    }

    public void onQ4(View view) {
        if (correctResponse == 3) {
            ((TextView) findViewById(R.id.bt4)).setText("Correct!");
        } else {
            ((TextView) findViewById(R.id.bt4)).setText("Incorrect!");
        }
        answerDialog(correctResponse == 3);
    }

    public void onQ5(View view) {
        if (correctResponse == 4) {
            ((TextView) findViewById(R.id.bt5)).setText("Correct!");
        } else {
            ((TextView) findViewById(R.id.bt5)).setText("Incorrect!");
        }
        answerDialog(correctResponse == 4);
    }
}