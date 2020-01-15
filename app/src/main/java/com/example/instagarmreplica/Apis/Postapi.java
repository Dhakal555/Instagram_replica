package com.example.instagarmreplica.Apis;

import com.example.instagarmreplica.model.PostList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Postapi {
    @GET("/userPost")
    Call<List<PostList>> getPosts();
}
