package com.example.mymovies.network;

import static com.example.mymovies.view.MainActivity.API_KEY;

import com.example.mymovies.model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiRequest {
    @GET("discover/movie?api_key="+API_KEY+"&sort_by=popularity.desc")
    Call<MovieModel> getRequest();
}
