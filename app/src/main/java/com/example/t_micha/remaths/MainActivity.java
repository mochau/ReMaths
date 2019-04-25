package com.example.t_micha.remaths;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import com.google.gson.Gson;
import io.github.kexanie.library.MathView;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Arrays;
import java.util.List;



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
}