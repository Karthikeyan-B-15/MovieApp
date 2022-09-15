package com.example.mymovies.network;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroRequest {
    public static String baseUrl="https://api.themoviedb.org/3/";
    public static Retrofit retrofit;
    public static Retrofit getRetroInstance(){
        if(retrofit==null){
            retrofit=new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
