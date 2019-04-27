package com.example.t_micha.remaths;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class SelectionMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //hide title bar
        getSupportActionBar().hide(); // hide title bar
        setContentView(R.layout.activity_selection_menu);
    }

    //Highlights the selected difficulty red and sets the API call for the selected difficulty
    public void setEasy(View view) {
        MathAPI.difficulty = "beginner";
        ((TextView) findViewById(R.id.bt_diff_easy)).setTextColor(Color.parseColor("#ED2939"));
        ((TextView) findViewById(R.id.bt_diff_med)).setTextColor(Color.parseColor("#000000"));
        ((TextView) findViewById(R.id.bt_diff_hard)).setTextColor(Color.parseColor("#000000"));

    }
    public void setMedium(View view) {
        MathAPI.difficulty = "intermediate";
        ((TextView) findViewById(R.id.bt_diff_easy)).setTextColor(Color.parseColor("#000000"));
        ((TextView) findViewById(R.id.bt_diff_med)).setTextColor(Color.parseColor("#ED2939"));
        ((TextView) findViewById(R.id.bt_diff_hard)).setTextColor(Color.parseColor("#000000"));
    }
    public void setHard(View view) {
        MathAPI.difficulty = "advanced";
        ((TextView) findViewById(R.id.bt_diff_easy)).setTextColor(Color.parseColor("#000000"));
        ((TextView) findViewById(R.id.bt_diff_med)).setTextColor(Color.parseColor("#000000"));
        ((TextView) findViewById(R.id.bt_diff_hard)).setTextColor(Color.parseColor("#ED2939"));
    }

    //Highlights the selected topic red and sets the API call for the selected topic
    public void topicSimple(View view) {
        MathAPI.topic = "Arithmetic";
        ((TextView) findViewById(R.id.bt_topic_simple)).setTextColor(Color.parseColor("#ED2939"));
        ((TextView) findViewById(R.id.bt_topic_calculus)).setTextColor(Color.parseColor("#000000"));
        ((TextView) findViewById(R.id.bt_topic_algebra)).setTextColor(Color.parseColor("#000000"));
        ((TextView) findViewById(R.id.bt_topic_fraction)).setTextColor(Color.parseColor("#000000"));
    }
    public void topicLinearEquation(View view) {
        MathAPI.topic = "Algebra";
        ((TextView) findViewById(R.id.bt_topic_simple)).setTextColor(Color.parseColor("#000000"));
        ((TextView) findViewById(R.id.bt_topic_calculus)).setTextColor(Color.parseColor("#000000"));
        ((TextView) findViewById(R.id.bt_topic_algebra)).setTextColor(Color.parseColor("#ED2939"));
        ((TextView) findViewById(R.id.bt_topic_fraction)).setTextColor(Color.parseColor("#000000"));
    }
    public void topicFractions(View view) {
        MathAPI.topic = "Fractions";
        ((TextView) findViewById(R.id.bt_topic_simple)).setTextColor(Color.parseColor("#000000"));
        ((TextView) findViewById(R.id.bt_topic_calculus)).setTextColor(Color.parseColor("#000000"));
        ((TextView) findViewById(R.id.bt_topic_algebra)).setTextColor(Color.parseColor("#000000"));
        ((TextView) findViewById(R.id.bt_topic_fraction)).setTextColor(Color.parseColor("#ED2939"));
    }
    public void topicPolynomial(View view) {
        MathAPI.topic = "Calculus";
        ((TextView) findViewById(R.id.bt_topic_simple)).setTextColor(Color.parseColor("#000000"));
        ((TextView) findViewById(R.id.bt_topic_calculus)).setTextColor(Color.parseColor("#ED2939"));
        ((TextView) findViewById(R.id.bt_topic_algebra)).setTextColor(Color.parseColor("#000000"));
        ((TextView) findViewById(R.id.bt_topic_fraction)).setTextColor(Color.parseColor("#000000"));
    }

    public void launchInstruction(View view) {
        Intent intent = new Intent(this, instruction.class);
        startActivity(intent);
    }
}
