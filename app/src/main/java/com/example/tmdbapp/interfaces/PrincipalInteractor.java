package com.example.tmdbapp.interfaces;

import com.example.tmdbapp.interactor.Peliculas;

import java.util.ArrayList;

public interface PrincipalInteractor {
    void obtenerDatos (String q);
    void procesoExitoso(ArrayList<Peliculas> peliculas);
    void procesoFallido();
    void mensajeError();
}
