package com.example.t_micha.remaths;

import android.os.AsyncTask;
import android.util.Log;
import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.Arrays;
import java.util.List;

public class MathAPI extends AsyncTask<Void, Void, MathResponse> {
    public static String difficulty = "beginner";
    public static String topic = "listSimple";

    @Override
    protected MathResponse doInBackground(Void... voids) {
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://math.ly/api/v1/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            MathService service = retrofit.create(MathService.class);
            Call<MathResponse> call = service.listLinearEquations(difficulty);
            if (topic.equals("listSimple")) {
                call = service.listSimple(difficulty);
            } else if (topic.equals("listLinearEquations")) {
                call = service.listLinearEquations(difficulty);
        }

            Response<MathResponse> response = call.execute();
            Log.e("AdviceAPI", "call works");
            if (response.body().getQuestion() != null) {
                return response.body();
            }
            List<String> APILimitedCall = Arrays.asList("Q1", "Q2", "Q3", "Q4", "Q5");
            return new MathResponse("ID - Error", "Question - API Call Limit Reached\n\nPlease wait as only 10 API calls can be made every 60 seconds.", APILimitedCall, -1, "Instruction - Error", "Category - Error", "Topic - Error", "Difficulty - Error");

        } catch (Exception e) {
            e.printStackTrace();
            Log.e("AdviceAPI", "call unsuccessful");
            List<String> APILimitedCall = Arrays.asList("Q1", "Q2", "Q3", "Q4", "Q5");
            return new MathResponse("ID - Error", "Question - API Call Limit Reached\n\nPlease wait as only 10 API calls can be made every 60 seconds.", APILimitedCall, -1, "Instruction - Error", "Category - Error", "Topic - Error", "Difficulty - Error");
        }

    }
    @Override
    protected void onPostExecute(MathResponse mathresponse) {
        MathQuestion.MR = mathresponse;
    }
}
