package com.example.tmdbapp.interfaces;

import com.example.tmdbapp.interactor.Peliculas;

import java.util.ArrayList;

public interface PrincipalPresenter  {

    void ocultarPeliculas();
    void procesoExitoso(ArrayList<Peliculas> peliculas);
    void obtenerDatos(String q);
    void mensajeError();
}