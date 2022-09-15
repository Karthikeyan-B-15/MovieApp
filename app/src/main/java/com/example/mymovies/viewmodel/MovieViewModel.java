package com.example.mymovies.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.mymovies.model.Results;
import com.example.mymovies.repository.MovieRepository;

import java.util.List;

public class MovieViewModel extends ViewModel {
    private MovieRepository movieRepository;
    private MutableLiveData<List<Results>> liveData;
   public MovieViewModel(){
        movieRepository=new MovieRepository();
        liveData=movieRepository.apiCall();
    }
    public LiveData<List<Results>> apiCall(){
     return liveData;

    }
}
