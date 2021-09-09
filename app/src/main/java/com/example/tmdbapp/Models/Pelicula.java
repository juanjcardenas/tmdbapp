package com.example.tmdbapp.models;

public class Pelicula {

    private String results;
//    private String original_language;
//    private String first_air_date;
//    private String vote_average;
//    private String overview;
//    private double vote_count;
//    private String poster_path;
//    private int id;
//    private String original_name;
//    private String origin_country;
//    private String genre_ids;
    private String name;
//    private String backdrop_path;
//    private double popularity;
//    private String media_type;


    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
