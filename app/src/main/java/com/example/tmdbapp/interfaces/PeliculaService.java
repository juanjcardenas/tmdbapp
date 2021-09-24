package com.example.tmdbapp.interfaces;

import com.example.tmdbapp.interactor.PeliculasRespuesta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PeliculaService {



    @GET("3/search/movie?api_key=cdaef7b595abd109ff25f3328c6badff&query=")
    Call<PeliculasRespuesta>obtenerPeliculas(@Query("query")String q);   //error

    @GET("3/movie/popular?api_key=cdaef7b595abd109ff25f3328c6badff&language=en-US&page=1")
    Call<PeliculasRespuesta>obtenerPopulares();

    @GET("3/movie/top_rated?api_key=cdaef7b595abd109ff25f3328c6badff&language=en-US&page=1")
    Call<PeliculasRespuesta>obtenerVotaciones();
}
