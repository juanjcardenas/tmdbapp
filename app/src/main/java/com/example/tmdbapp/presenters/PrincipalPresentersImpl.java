package com.example.tmdbapp.presenters;

import com.example.tmdbapp.interactor.Peliculas;
import com.example.tmdbapp.interactor.PrinciapalInteractorImpl;
import com.example.tmdbapp.interfaces.PrincipalInteractor;
import com.example.tmdbapp.interfaces.PrincipalPresenter;
import com.example.tmdbapp.interfaces.PrincipalView;
import com.example.tmdbapp.views.PrincipalActivityView;

import java.util.ArrayList;

public class PrincipalPresentersImpl implements PrincipalPresenter {

    private PrincipalView view;
    private PrincipalInteractor interactor;

    public PrincipalPresentersImpl(PrincipalActivityView view){

        this.interactor = new PrinciapalInteractorImpl(this);
        this.view = view;
    }

    @Override
    public void ocultarPeliculas() {
        view.ocultarPeliculas();
    }

    @Override
    public void procesoExitoso(ArrayList<Peliculas> peliculas) {
        view.mostrarPeliculas(peliculas);
    }

    @Override
    public void procesoExitosoVotadas(ArrayList<Peliculas> peliculas) {
        view.mostrarVotadas(peliculas);

    }

    @Override
    public void procesoExitosoPopulares(ArrayList<Peliculas> peliculas) {
        view.mostrarPopulares(peliculas);
    }

    @Override
    public void obtenerPeliculas(String q) {
        System.out.println("Mensaje--> Obtener peliculas presen");
        interactor.obtenerPeliculas(q);
    }

    @Override
    public void obtenerPopulares() {
        interactor.obtenerPopulares();
    }

    @Override
    public void obtenerVotadas() {
        interactor.obtenerVotadas();
    }


    @Override
    public void mensajeError() {
        view.mensajeError();
    }

}
