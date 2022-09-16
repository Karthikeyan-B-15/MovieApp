package com.example.mymovies.model;
public class DetailModel {
    private String backdrop_path;
    private String overview;
    private String release_date;
    private String original_language;
    private String budget;
    private String revenue;
    private String runtime;
    private String vote_average;
    public DetailModel(String backdrop_path, String overview, String release_date, String original_language, String budget, String revenue, String runtime, String vote_average) {
        this.backdrop_path = backdrop_path;
        this.overview = overview;
        this.release_date = release_date;
        this.original_language = original_language;
        this.budget = budget;
        this.revenue = revenue;
        this.runtime = runtime;
        this.vote_average = vote_average;
    }

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public String getBudget() {
        return budget;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public String getRevenue() {
        return revenue;
    }

    public void setRevenue(String revenue) {
        this.revenue = revenue;
    }

    public String getRuntime() {
        return runtime;
    }

    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }

    public String getVote_average() {
        return vote_average;
    }

    public void setVote_average(String vote_average) {
        this.vote_average = vote_average;
    }
}
