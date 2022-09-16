package com.example.mymovies.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.mymovies.model.DetailModel;
import com.example.mymovies.model.MovieModel;
import com.example.mymovies.model.Results;
import com.example.mymovies.network.ApiRequest;
import com.example.mymovies.network.RetroRequest;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieRepository {
    private ApiRequest apiRequest;

    public MovieRepository() {
        this.apiRequest = RetroRequest.getRetroInstance().create(ApiRequest.class);
    }
    public MutableLiveData<List<Results>> apiCall(){
        MutableLiveData<List<Results>> data=new MutableLiveData<>();
        apiRequest.getRequest().enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                if(response.body()!=null){
                    Log.d("msg", String.valueOf(response.body().getResults()));
                    data.postValue(response.body().getResults());
                }
                else {

                }
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {
                Log.d("err", String.valueOf(t));
            }
        });
       return data;
    }
    public void detailApiCall(String id,MutableLiveData<DetailModel> liveData){
        apiRequest.getDetail(id).enqueue(new Callback<DetailModel>() {
            @Override
            public void onResponse(Call<DetailModel> call, Response<DetailModel> response) {
                Log.d("res",response.body().getBudget());
                if(response.body()!=null){
                    liveData.postValue(response.body());
                }
                else {
                    liveData.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<DetailModel> call, Throwable t) {

            }
        });
    }
}
