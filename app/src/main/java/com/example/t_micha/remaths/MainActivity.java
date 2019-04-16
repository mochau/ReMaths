package com.example.t_micha.remaths;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
//import io.github.kexanie.library.MathView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public int correctResponse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_main);
        MathAPI dummyMathAPI = new MathAPI();
        MathResponse MR = dummyMathAPI.returnMath();
        ((TextView) findViewById(R.id.tvQs)).setText(MR.getQuestion());
        ((TextView) findViewById(R.id.bt1)).setText(MR.getChoices().get(0));
        ((TextView) findViewById(R.id.bt2)).setText(MR.getChoices().get(1));
        ((TextView) findViewById(R.id.bt3)).setText(MR.getChoices().get(2));
        ((TextView) findViewById(R.id.bt4)).setText(MR.getChoices().get(3));
        ((TextView) findViewById(R.id.bt5)).setText(MR.getChoices().get(4));
        correctResponse = MR.getCorrectChoice();
        WebView w = (WebView) findViewById(R.id.wvMath);
        w.getSettings().setJavaScriptEnabled(true);
        w.loadDataWithBaseURL(null,"<script type='text/javascript' async src='https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.5/MathJax.js?config=TeX-MML-AM_CHTML'></script>" +
                        MR.getQuestion(),
                "text/html","utf-8",null);
        //MathView f1 = (MathView) findViewById(R.id.mv_f1);
    }

    public void onRefresh(View view) {
        MathAPI dummyMathAPI = new MathAPI();
        MathResponse MR = dummyMathAPI.returnMath();
        ((TextView) findViewById(R.id.tvQs)).setText(MR.getQuestion());
        ((TextView) findViewById(R.id.bt1)).setText(MR.getChoices().get(0));
        ((TextView) findViewById(R.id.bt2)).setText(MR.getChoices().get(1));
        ((TextView) findViewById(R.id.bt3)).setText(MR.getChoices().get(2));
        ((TextView) findViewById(R.id.bt4)).setText(MR.getChoices().get(3));
        ((TextView) findViewById(R.id.bt5)).setText(MR.getChoices().get(4));
        correctResponse = MR.getCorrectChoice();
        WebView w = (WebView) findViewById(R.id.wvMath);
        w.getSettings().setJavaScriptEnabled(true);
        w.loadDataWithBaseURL(null,"<script type='text/javascript' async src='https://cdnjs.cloudflare.com/ajax/libs/mathjax/2.7.5/MathJax.js?config=TeX-MML-AM_CHTML'></script>" +
                        MR.getQuestion(),
                "text/html","utf-8",null);
    }

    public void onQ1(View view) {
        if (correctResponse == 0) {
            ((TextView) findViewById(R.id.bt1)).setText("Correct!");
        } else {
            ((TextView) findViewById(R.id.bt1)).setText("Incorrect!");
        }
    }

    public void onQ2(View view) {
        if (correctResponse == 1) {
            ((TextView) findViewById(R.id.bt2)).setText("Correct!");
        } else {
            ((TextView) findViewById(R.id.bt2)).setText("Incorrect!");
        }
    }

    public void onQ3(View view) {
        if (correctResponse == 2) {
            ((TextView) findViewById(R.id.bt3)).setText("Correct!");
        } else {
            ((TextView) findViewById(R.id.bt3)).setText("Incorrect!");
        }
    }

    public void onQ4(View view) {
        if (correctResponse == 3) {
            ((TextView) findViewById(R.id.bt4)).setText("Correct!");
        } else {
            ((TextView) findViewById(R.id.bt4)).setText("Incorrect!");
        }
    }

    public void onQ5(View view) {
        if (correctResponse == 4) {
            ((TextView) findViewById(R.id.bt5)).setText("Correct!");
        } else {
            ((TextView) findViewById(R.id.bt5)).setText("Incorrect!");
        }
    }
}