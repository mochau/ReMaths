package com.example.t_micha.remaths;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import io.github.kexanie.library.MathView;
import java.util.Arrays;
import java.util.List;

public class MathQuestion extends AppCompatActivity {

    static List<String> APILimitedCall = Arrays.asList("Q1", "Q2", "Q3", "Q4", "Q5");
    public static MathResponse MR = new MathResponse("ID - Error", "Question - API Call Limit Reached\n\nPlease wait as only 10 API calls can be made every 60 seconds.", APILimitedCall, -1, "Instruction - Error", "Category - Error", "Topic - Error", "Difficulty - Error");
    public int correctResponse;
    public static int score = 0;
    CountDownTimer td;
    boolean timeout_flag = false;
    public static String userName = "user";
    public static int qs_count = 0; //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //hide title bar
        getSupportActionBar().hide(); // hide title bar
        setContentView(R.layout.activity_math_question);
        userName = getIntent().getStringExtra("NAME_MESSAGE");
        onRefresh(null);
    }


    public void onRefresh(View view) {
        new MathAPI().execute();

        qs_count++; //counts question number
        correctResponse = MR.getCorrectChoice(); //retrieves correct answer

        //counts score
        ((TextView) findViewById(R.id.tv_score)).setText("Question: \n   " + (qs_count) + " / 5");

        //prepares the question
        ((MathView) findViewById(R.id.mv_qs)).config("MathJax.Hub.Config({\"HTML-CSS\": {scale: 180}});");
        ((MathView) findViewById(R.id.mv_qs)).setText("<math>" + MR.getQuestion() + "</math>");

        //prepares the answer button and answer
        ((MathView) findViewById(R.id.mv_1)).config("MathJax.Hub.Config({\"HTML-CSS\": {scale: 150}});");
        ((MathView) findViewById(R.id.mv_1)).setText(MR.getChoices().get(0));
        ((MathView) findViewById(R.id.mv_2)).config("MathJax.Hub.Config({\"HTML-CSS\": {scale: 150}});");
        ((MathView) findViewById(R.id.mv_2)).setText(MR.getChoices().get(1));
        ((MathView) findViewById(R.id.mv_3)).config("MathJax.Hub.Config({\"HTML-CSS\": {scale: 150}});");
        ((MathView) findViewById(R.id.mv_3)).setText(MR.getChoices().get(2));
        ((MathView) findViewById(R.id.mv_4)).config("MathJax.Hub.Config({\"HTML-CSS\": {scale: 150}});");
        ((MathView) findViewById(R.id.mv_4)).setText(MR.getChoices().get(3));
        ((MathView) findViewById(R.id.mv_5)).config("MathJax.Hub.Config({\"HTML-CSS\": {scale: 150}});");
        ((MathView) findViewById(R.id.mv_5)).setText(MR.getChoices().get(4));
        ((TextView) findViewById(R.id.bt1)).setText("Q1");
        ((TextView) findViewById(R.id.bt2)).setText("Q2");
        ((TextView) findViewById(R.id.bt3)).setText("Q3");
        ((TextView) findViewById(R.id.bt4)).setText("Q4");
        ((TextView) findViewById(R.id.bt5)).setText("Q5");

        //update visual element of the answer button
        findViewById(R.id.bt1).setBackgroundResource(R.drawable.round_next_button);
        findViewById(R.id.bt2).setBackgroundResource(R.drawable.round_next_button);
        findViewById(R.id.bt3).setBackgroundResource(R.drawable.round_next_button);
        findViewById(R.id.bt4).setBackgroundResource(R.drawable.round_next_button);
        findViewById(R.id.bt5).setBackgroundResource(R.drawable.round_next_button);

       //instantiates a timer which disables all answer buttons when time runs out
        td = new CountDownTimer(15000, 1000) {
            public void onTick(long millisUntilFinished) {
                ((TextView) findViewById(R.id.tv_timer)).setText(String.valueOf(millisUntilFinished / 1000));
                findViewById(R.id.bt1).setEnabled(true);
                findViewById(R.id.bt2).setEnabled(true);
                findViewById(R.id.bt3).setEnabled(true);
                findViewById(R.id.bt4).setEnabled(true);
                findViewById(R.id.bt5).setEnabled(true);
                findViewById(R.id.btRefresh).setVisibility(View.GONE);
                timeout_flag = false;
                if (millisUntilFinished < 1000) {
                    timeout_flag = true;
                    answerDialog(false);
                    findViewById(R.id.btRefresh).setVisibility(View.VISIBLE);
                }
            }
            public void onFinish() {
                ((TextView) findViewById(R.id.tv_timer)).setText("0");
                findViewById(R.id.bt1).setEnabled(false);
                findViewById(R.id.bt2).setEnabled(false);
                findViewById(R.id.bt3).setEnabled(false);
                findViewById(R.id.bt4).setEnabled(false);
                findViewById(R.id.bt5).setEnabled(false);
            }
        }.start();
    }

    //produces a CORRECT or INCORRECT or OUT OF TIME dialog when the user answers a question
    private void answerDialog(boolean Answer) {
        td.onFinish();
        td.cancel();
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setCancelable(false);
        if (Answer) {
            dialog.setMessage("Good work " + userName);
            dialog.setTitle("Correct");
            score++;
            ((TextView) findViewById(R.id.tv_score)).setText("Question: \n  " + (qs_count) + " / 5");
        } else if (timeout_flag) {
            dialog.setMessage("Please work faster " + userName);
            dialog.setTitle("Out of Time");
        } else if (!MathAPI.APIWorking) {
            dialog.setMessage("Can only make 10 API Calls every 60 seconds. Please try again! " + userName);
            dialog.setTitle("API Limit Reached");
        } else {
            dialog.setMessage("Please study harder " + userName);
            dialog.setTitle("Incorrect");
        }
        //After 5 questions the user is redirected to a results page
        if (qs_count == 5) {
            dialog.setPositiveButton("Finish",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            launchResultPage(null);
                        }
                    });
        } else {
            dialog.setPositiveButton("next question",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            onRefresh(null);
                        }
                    });
        }

        dialog.setNegativeButton("review", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                findViewById(R.id.btRefresh).setVisibility(View.VISIBLE);
            }
        });
        AlertDialog alertDialog = dialog.create();
        if (!isFinishing()) {
            alertDialog.show();
        }
    }

    //Sets up all the answer button to check if the answer is correct (Q1, Q2, Q3, Q4, Q5)
    public void onQ1(View view) {
        if (correctResponse == 0) {
            ((TextView) findViewById(R.id.bt1)).setText("Correct!");
            findViewById(R.id.bt1).setBackgroundResource(R.drawable.correct_answer);
        } else {
            ((TextView) findViewById(R.id.bt1)).setText("Incorrect!");
            findViewById(R.id.bt1).setBackgroundResource(R.drawable.wrong_answer);
        }
        answerDialog(correctResponse == 0);
    }

    public void onQ2(View view) {
        if (correctResponse == 1) {
            ((TextView) findViewById(R.id.bt2)).setText("Correct!");
            findViewById(R.id.bt2).setBackgroundResource(R.drawable.correct_answer);
        } else {
            ((TextView) findViewById(R.id.bt2)).setText("Incorrect!");
            findViewById(R.id.bt2).setBackgroundResource(R.drawable.wrong_answer);
        }
        answerDialog(correctResponse == 1);
    }

    public void onQ3(View view) {
        if (correctResponse == 2) {
            ((TextView) findViewById(R.id.bt3)).setText("Correct!");
            findViewById(R.id.bt3).setBackgroundResource(R.drawable.correct_answer);
        } else {
            ((TextView) findViewById(R.id.bt3)).setText("Incorrect!");
            findViewById(R.id.bt3).setBackgroundResource(R.drawable.wrong_answer);
        }
        answerDialog(correctResponse == 2);
    }

    public void onQ4(View view) {
        if (correctResponse == 3) {
            ((TextView) findViewById(R.id.bt4)).setText("Correct!");
            findViewById(R.id.bt4).setBackgroundResource(R.drawable.correct_answer);
        } else {
            ((TextView) findViewById(R.id.bt4)).setText("Incorrect!");
            findViewById(R.id.bt4).setBackgroundResource(R.drawable.wrong_answer);
        }
        answerDialog(correctResponse == 3);
    }

    public void onQ5(View view) {
        if (correctResponse == 4) {
            ((TextView) findViewById(R.id.bt5)).setText("Correct!");
            findViewById(R.id.bt5).setBackgroundResource(R.drawable.correct_answer);
        } else {
            ((TextView) findViewById(R.id.bt5)).setText("Incorrect!");
            findViewById(R.id.bt5).setBackgroundResource(R.drawable.wrong_answer);
        }
        answerDialog(correctResponse == 4);
    }

    public void launchResultPage(View view) {
        Intent intent = new Intent(this, ResultPage.class);
        startActivity(intent);
    }

}