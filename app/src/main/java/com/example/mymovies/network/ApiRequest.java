package com.example.mymovies.network;

import static com.example.mymovies.view.MainActivity.API_KEY;

import com.example.mymovies.model.DetailModel;
import com.example.mymovies.model.MovieModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiRequest {
    @GET("discover/movie?api_key="+API_KEY+"&sort_by=popularity.desc")
    Call<MovieModel> getRequest();
    @GET("movie/{id}?api_key="+API_KEY)
    Call<DetailModel> getDetail(@Path("id") String query);
}
