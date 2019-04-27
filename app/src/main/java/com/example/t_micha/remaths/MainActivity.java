package com.example.t_micha.remaths;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {
    CountDownTimer td;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //hide title bar
        getSupportActionBar().hide(); // hide title bar
        setContentView(R.layout.activity_main);

        //Loads for 3 seconds before entering SelectionMenu Activity
        td = new CountDownTimer(3000, 1000) {
            public void onTick(long millisUntilFinished) {
                            }
            public void onFinish() {
                launchSelectionMenu(null);
            }
        }.start();
    }

    public void launchSelectionMenu(View view) {
        Intent intent = new Intent(this, SelectionMenu.class);
        startActivity(intent);
    }
}