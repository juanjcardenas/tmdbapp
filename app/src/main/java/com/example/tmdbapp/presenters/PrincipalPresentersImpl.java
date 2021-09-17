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
    public void obtenerDatos(String q) {
        interactor.obtenerDatos(q);
    }


    @Override
    public void mensajeError() {
        view.mensajeError();
    }

}
