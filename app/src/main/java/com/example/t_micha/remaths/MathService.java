package com.example.t_micha.remaths;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MathService {
    @GET("algebra/equations-involving-fractions.json")
    Call<MathResponse> listMaths(@Query("difficulty") String difficulty);
}
