package com.example.tmdbapp.interfaces;


import com.example.tmdbapp.interactor.Peliculas;

import java.util.ArrayList;

public interface PrincipalView {

    void mostrarVotadas(ArrayList<Peliculas> peliculas);
    void mostrarPopulares(ArrayList<Peliculas> peliculas);
    void mostrarPeliculas(ArrayList<Peliculas> peliculas);
    void ocultarPeliculas();
    void enviarPeliculas(String q);
    void obtenerVotadas();
    void obtenerPopulares();
    void mensajeError();

}
