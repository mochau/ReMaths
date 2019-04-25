package com.example.t_micha.remaths;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ResultPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_page);
        ((TextView) findViewById(R.id.tv_result)).setText("Score: \n" + MathQuestion.score + " / 5");
    }
}
