package com.example.t_micha.remaths;

import com.google.gson.Gson;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

public class MathAPI {

    public MathResponse returnMath() {
        MathResponse dummyMathsResponse = new MathResponse();
        try {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://math.ly/api/v1/algebra/linear-equations.json?difficulty=beginner")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            MathService service = retrofit.create(MathService.class);
            Gson gson = new Gson();
            Call<MathResponse> call = service.listMaths();
            Response<MathResponse> response = call.execute();
            return response.body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dummyMathsResponse;
    }
}

