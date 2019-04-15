package com.example.t_micha.remaths;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MathService {
    @GET("math")
    Call<MathResponse> listMaths();
}
