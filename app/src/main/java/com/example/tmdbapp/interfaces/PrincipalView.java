package com.example.tmdbapp.interfaces;
import retrofit2.Call;
import retrofit2.http.GET;

import com.example.tmdbapp.models.PeliculaRespuesta;

public interface PrincipalView {
    @GET("day?api_key=cdaef7b595abd109ff25f3328c6badff")
    Call<PeliculaRespuesta> getListaPeliculas();


}
