package com.example.tmdbapp.interactor;

public class Peliculas {
    private String poster_path;
    private String original_title;
    private String release_date;
    private Integer vote_count;


    public Peliculas (){

    }
    public Peliculas(String results, String poster_path, String original_title, String release_date, Integer vote_count) {
        this.poster_path = poster_path;
        this.original_title = original_title;
        this.release_date = release_date;
        this.vote_count = vote_count;
    }

    public String getPoster_path() {
        return poster_path;
    }

    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getOriginal_title() {
        return original_title;
    }

    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public Integer getVote_count() {
        return vote_count;
    }

    public void setVote_count(Integer vote_count) {
        this.vote_count = vote_count;
    }
}
