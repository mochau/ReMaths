package com.example.t_micha.remaths;

import android.os.AsyncTask;
import android.util.Log;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Arrays;
import java.util.List;

public class MathAPI extends AsyncTask<Void, Void, MathResponse> {
    public static String difficulty = "beginner"; //stores difficulty level
    public static String topic = "Arithmetic"; //stores topic
    public static boolean APIWorking;

    @Override
    protected MathResponse doInBackground(Void... voids) {
        //Using the retrofit library to do an API call
        try {
            APIWorking = true;
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://math.ly/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            MathService service = retrofit.create(MathService.class);
            Call<MathResponse> call = service.listLinearEquations(difficulty);
            //Takes in difficulty level as a parameter then
            //Executes a different call based on the topic chosen
            if (topic.equals("Arithmetic")) {
                call = service.listSimple(difficulty);
            } else if (topic.equals("Algebra")) {
                call = service.listLinearEquations(difficulty);
            } else if (topic.equals("Fractions")) {
                call = service.listFractions(difficulty);
            } else if (topic.equals("Calculus")) {
                call = service.listPolynomial(difficulty);
        }
            Response<MathResponse> response = call.execute();
            Log.e("AdviceAPI", "call works");
            if (response.body().getQuestion() != null) {
                return response.body();
            }
            //Prepares clean error message if the API call fails
            APIWorking = false;
            List<String> APILimitedCall = Arrays.asList("Q1", "Q2", "Q3", "Q4", "Q5");
            return new MathResponse("ID - Error", "Question - API Call Limit Reached\n\nPlease wait as only 10 API calls can be made every 60 seconds.", APILimitedCall, -1, "Instruction - Error", "Category - Error", "Topic - Error", "Difficulty - Error");

        } catch (Exception e) {
            //Prepares clean error message if the API call fails
            APIWorking = false;
            e.printStackTrace();
            Log.e("AdviceAPI", "call unsuccessful");
            List<String> APILimitedCall = Arrays.asList("Q1", "Q2", "Q3", "Q4", "Q5");
            return new MathResponse("ID - Error", "Question - API Call Limit Reached\n\nPlease wait as only 10 API calls can be made every 60 seconds.", APILimitedCall, -1, "Instruction - Error", "Category - Error", "Topic - Error", "Difficulty - Error");
        }

    }
    //Sets the MathResponse to a static variable accessible by other classes
    @Override
    protected void onPostExecute(MathResponse mathresponse) {
        MathQuestion.MR = mathresponse;
    }
}
