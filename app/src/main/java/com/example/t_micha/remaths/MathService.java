package com.example.t_micha.remaths;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//interface containing a list of API requests
public interface MathService {
    @GET("arithmetic/simple.json")
    Call<MathResponse> listSimple(@Query("difficulty") String difficulty);

    @GET("algebra/linear-equations.json")
    Call<MathResponse> listLinearEquations(@Query("difficulty") String difficulty);

    @GET("arithmetic/fractions.json")
    Call<MathResponse> listFractions(@Query("difficulty") String difficulty);

    @GET("calculus/polynomial-differentiation.json")
    Call<MathResponse> listPolynomial(@Query("difficulty") String difficulty);
}
