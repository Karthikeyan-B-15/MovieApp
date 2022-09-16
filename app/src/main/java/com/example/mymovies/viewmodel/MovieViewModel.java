package com.example.mymovies.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mymovies.model.DetailModel;
import com.example.mymovies.model.Results;
import com.example.mymovies.repository.MovieRepository;
import com.example.mymovies.view.MovieDetails;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private MovieRepository movieRepository;
    private MutableLiveData<List<Results>> liveData;
    private MutableLiveData<DetailModel> detailLiveData;
   public MovieViewModel(){
        movieRepository=new MovieRepository();
        liveData=movieRepository.apiCall();
        detailLiveData=new MutableLiveData<>();
    }
    public LiveData<List<Results>> apiCall(){
     return liveData;

    }
    public void getDetail(String val){
       movieRepository.detailApiCall(val,detailLiveData);
    }
    public LiveData<DetailModel> getLiveData(){
       return detailLiveData;
    }
}
