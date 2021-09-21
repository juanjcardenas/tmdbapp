package com.example.tmdbapp.interfaces;

import com.example.tmdbapp.interactor.Peliculas;

import java.util.ArrayList;

public interface PrincipalPresenter  {

    void ocultarPeliculas();
    void procesoExitoso(ArrayList<Peliculas> peliculas);
    void procesoExitosoVotadas(ArrayList<Peliculas> peliculas);
    void procesoExitosoPopulares(ArrayList<Peliculas> peliculas);
    void obtenerPeliculas(String q);
    void obtenerPopulares ();
    void obtenerVotadas();
    void mensajeError();
}