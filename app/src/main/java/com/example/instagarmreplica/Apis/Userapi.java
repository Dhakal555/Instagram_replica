package com.example.instagarmreplica.Apis;

import com.example.instagarmreplica.model.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Userapi {

    @POST("user/register")
    Call<Void> register(@Body User user);

    @POST("user/login")
    Call<Void> login(@Body User user);
}
