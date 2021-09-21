package com.example.tmdbapp.interfaces;

import com.example.tmdbapp.interactor.Peliculas;

import java.util.ArrayList;

public interface PrincipalInteractor {
    void obtenerPeliculas (String q);
    void obtenerVotadas ();
    void obtenerPopulares ();
    void procesoExitoso (ArrayList<Peliculas> peliculas);
    void procesoExitosoVotadas(ArrayList<Peliculas> peliculas);
    void procesoFallido();
    void mensajeError();
    void procesoExitosoPopulares(ArrayList<Peliculas> peliculas);
}
