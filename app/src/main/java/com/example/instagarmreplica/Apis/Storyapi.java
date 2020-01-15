package com.example.instagarmreplica.Apis;

import com.example.instagarmreplica.model.Story;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Storyapi {
    @GET("/stories")
    Call<List<Story>> getStories();
}
