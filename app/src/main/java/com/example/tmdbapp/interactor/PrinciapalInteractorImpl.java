package com.example.tmdbapp.interactor;

import com.example.tmdbapp.interfaces.PeliculaService;
import com.example.tmdbapp.interfaces.PrincipalInteractor;
import com.example.tmdbapp.interfaces.PrincipalPresenter;
import com.example.tmdbapp.presenters.PrincipalPresentersImpl;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PrinciapalInteractorImpl implements PrincipalInteractor {

    private PrincipalPresenter principalPresenter;

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public PrinciapalInteractorImpl(PrincipalPresentersImpl principalPresenter) {
        this.principalPresenter = principalPresenter;
    }

    @Override
    public void obtenerPeliculas(String q) {
        PeliculaService service = retrofit.create(PeliculaService.class);
        Call<PeliculasRespuesta> call=service.obtenerPeliculas(q);

        call.enqueue(new Callback<PeliculasRespuesta>() {

            @Override
            public void onResponse(Call<PeliculasRespuesta> call, Response<PeliculasRespuesta> response) {
                if(!response.isSuccessful()){
                    procesoFallido();
                    return;
                }
                PeliculasRespuesta datosPeliculas = response.body();
                ArrayList<Peliculas> peliculas = datosPeliculas.getResults();

                if(datosPeliculas!=null){
                    procesoExitoso(peliculas);
                }
            }

            @Override
            public void onFailure(Call<PeliculasRespuesta> call, Throwable t) {
                procesoFallido();
                mensajeError();
            }
        });
    }

    @Override
    public void obtenerVotadas() {

        PeliculaService service = retrofit.create(PeliculaService.class);
        Call<PeliculasRespuesta> call = service.obtenerVotaciones();

        call.enqueue(new Callback<PeliculasRespuesta>() {
            @Override
            public void onResponse(Call<PeliculasRespuesta> call, Response<PeliculasRespuesta> response) {
                if(!response.isSuccessful()){
                    procesoFallido();
                    return;
                }
                PeliculasRespuesta datosPeliculas = response.body();
                ArrayList<Peliculas> peliculas = datosPeliculas.getResults();

                if(datosPeliculas!=null){
                    procesoExitosoVotadas(peliculas);
                }
            }

            @Override
            public void onFailure(Call<PeliculasRespuesta> call, Throwable t) {
                procesoFallido();
                mensajeError();
            }
        });
    }

    @Override
    public void obtenerPopulares() {
        PeliculaService service = retrofit.create(PeliculaService.class);
        Call<PeliculasRespuesta> call = service.obtenerPopulares();

        call.enqueue(new Callback<PeliculasRespuesta>() {
            @Override
            public void onResponse(Call<PeliculasRespuesta> call, Response<PeliculasRespuesta> response) {
                if(!response.isSuccessful()){
                    procesoFallido();
                    return;
                }
                PeliculasRespuesta datosPeliculas = response.body();
                ArrayList<Peliculas> peliculas = datosPeliculas.getResults();

                if(datosPeliculas!=null){
                    procesoExitosoPopulares(peliculas);
                }
            }

            @Override
            public void onFailure(Call<PeliculasRespuesta> call, Throwable t) {
                procesoFallido();
                mensajeError();
            }
        });
    }

    @Override
    public void procesoExitoso(ArrayList<Peliculas> peliculas) {
        principalPresenter.procesoExitoso(peliculas);
    }


    @Override
    public void procesoExitosoVotadas(ArrayList<Peliculas> peliculas) {
        principalPresenter.procesoExitosoVotadas(peliculas);
    }

    @Override
    public void procesoFallido() {
        principalPresenter.ocultarPeliculas();
    }

    @Override
    public void mensajeError() {
        principalPresenter.mensajeError();
    }


    @Override
    public void procesoExitosoPopulares(ArrayList<Peliculas> peliculas) {
        principalPresenter.procesoExitosoPopulares(peliculas);
    }
}
