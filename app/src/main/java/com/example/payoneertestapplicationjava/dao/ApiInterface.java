package com.example.payoneertestapplicationjava.dao;

import com.example.payoneertestapplicationjava.models.ApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface ApiInterface {
    @Headers("Content-Type: application/json")
    @GET("lists/listresult.json")
    Call<ApiResponse> getPaymentMethods();

}
