package com.example.t_micha.remaths;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        setContentView(R.layout.activity_main);
        MathAPI dummyMathAPI = new MathAPI();
        ((TextView) findViewById(R.id.tvQs)).setText(dummyMathAPI.returnMath().getQuestion());
    }

    public void onClick(View view) {
        MathAPI dummyMathAPI = new MathAPI();
        ((TextView) findViewById(R.id.tvQs)).setText(dummyMathAPI.returnMath().toString());
    }
}