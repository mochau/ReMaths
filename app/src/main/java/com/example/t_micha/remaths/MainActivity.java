package com.example.t_micha.remaths;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity {
    //public static final String EXTRA_MESSAGE = "com.example.t_micha.remaths.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //hide title bar
        getSupportActionBar().hide(); // hide title bar
        setContentView(R.layout.activity_main);
    }

    public void launchSelectionMenu(View view) {
        Intent intent = new Intent(this, SelectionMenu.class);
        startActivity(intent);
    }
}