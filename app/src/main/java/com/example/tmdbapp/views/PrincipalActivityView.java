package com.example.tmdbapp.views;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tmdbapp.Adapters.AdapterPeliculas;
import com.example.tmdbapp.R;
import com.example.tmdbapp.interactor.Peliculas;
import com.example.tmdbapp.interfaces.PrincipalPresenter;
import com.example.tmdbapp.interfaces.PrincipalView;
import com.example.tmdbapp.presenters.PrincipalPresentersImpl;

import java.util.ArrayList;

public class PrincipalActivityView extends AppCompatActivity implements SearchView.OnQueryTextListener, PrincipalView {

     private PrincipalPresenter presenter;
     private RecyclerView recyclerView;
     private AdapterPeliculas adapterPeliculas;
     private TextView emensaje;
     androidx.appcompat.widget.SearchView search;

     private PrincipalPresentersImpl principalPresenters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        recyclerView = findViewById(R.id.peliculas);
        search  = findViewById(R.id.search);
        search.setOnQueryTextListener(this);
        emensaje = findViewById(R.id.menerror);
        presenter = new PrincipalPresentersImpl(this);
        recyclerView.setVisibility(View.VISIBLE);


    }

    @Override
    public void mostrarPeliculas(ArrayList<Peliculas> peliculas) {
        adapterPeliculas = new AdapterPeliculas(peliculas, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        emensaje.setVisibility(View.GONE);
        recyclerView.setAdapter(adapterPeliculas);
        recyclerView.setLayoutManager((new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)));

    }

    @Override
    public void ocultarPeliculas() {
        recyclerView.setVisibility(View.GONE);
    }

    @Override
    public void obtenerDatos(String q) {
        presenter.obtenerDatos(q);
    }

    @Override
    public void mensajeError() {
        recyclerView.setVisibility(View.GONE);
        emensaje.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onQueryTextSubmit(String q) {
        obtenerDatos(q);
        return false;
    }


    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
