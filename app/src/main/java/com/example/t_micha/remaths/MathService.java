package com.example.t_micha.remaths;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MathService {
    @GET("arithmetic/simple.json")
    Call<MathResponse> listSimple(@Query("difficulty") String difficulty);

    @GET("algebra/linear-equations.json")
    Call<MathResponse> listLinearEquations(@Query("difficulty") String difficulty);
}
