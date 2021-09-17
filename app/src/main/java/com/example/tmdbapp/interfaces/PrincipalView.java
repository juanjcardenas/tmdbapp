package com.example.tmdbapp.interfaces;


import com.example.tmdbapp.interactor.Peliculas;

import java.util.ArrayList;

public interface PrincipalView {

    void mostrarPeliculas(ArrayList<Peliculas> peliculas);
    void ocultarPeliculas();
    void obtenerDatos (String q);
    void mensajeError();

}
