package com.example.mymovies.model;

import java.util.List;

public class MovieModel {
    private List<Results> results;

    public List<Results> getResults() {
        return results;
    }

    public void setResults(List<Results> results) {
        this.results = results;
    }

    public MovieModel(List<Results> results) {
        this.results = results;
    }
}
