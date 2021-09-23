package com.example.tmdbapp.views;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tmdbapp.Adapters.AdapterPeliculas;
import com.example.tmdbapp.Adapters.AdapterVotadas;
import com.example.tmdbapp.R;
import com.example.tmdbapp.interactor.Peliculas;
import com.example.tmdbapp.interfaces.PrincipalPresenter;
import com.example.tmdbapp.interfaces.PrincipalView;
import com.example.tmdbapp.presenters.PrincipalPresentersImpl;

import java.util.ArrayList;

public class PrincipalActivityView extends AppCompatActivity implements SearchView.OnQueryTextListener, PrincipalView {

     private PrincipalPresenter presenter;
     private RecyclerView recyclerView, recyclerView2;
     private AdapterPeliculas adapterPeliculas;
     private AdapterVotadas adapterVotadas;
     private TextView emensaje;
     private EditText buscador;


     private PrincipalPresentersImpl principalPresenters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        recyclerView = findViewById(R.id.peliculas);
        recyclerView2 = findViewById(R.id.peliculas2);
        buscador  = findViewById(R.id.buscador);
//        buscador.setOnQueryTextListener(this);
        emensaje = findViewById(R.id.menerror);
        presenter = new PrincipalPresentersImpl(this);
        recyclerView.setVisibility(View.VISIBLE);
        recyclerView2.setVisibility(View.VISIBLE);
        obtenerVotadas();
        obtenerPopulares();


    }

    @Override
    public void mostrarVotadas(ArrayList<Peliculas> peliculas) {
        adapterVotadas = new AdapterVotadas(peliculas, this);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        emensaje.setVisibility(View.GONE);
        recyclerView2.setAdapter(adapterVotadas);
    }

    @Override
    public void mostrarPopulares(ArrayList<Peliculas> peliculas) {
        adapterPeliculas = new AdapterPeliculas(peliculas, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        emensaje.setVisibility(View.GONE);
        recyclerView.setAdapter(adapterPeliculas);
        recyclerView.setLayoutManager((new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)));

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
    public void enviarPeliculas(String q) {
        presenter.obtenerPeliculas(q);
        buscador.clearFocus();
    }

    @Override
    public void obtenerVotadas() {
        presenter.obtenerVotadas();
    }

    @Override
    public void obtenerPopulares() {
        presenter.obtenerPopulares();
    }

    @Override
    public void mensajeError() {
        recyclerView.setVisibility(View.GONE);
        emensaje.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onQueryTextSubmit(String q) {
        enviarPeliculas(q);
        return false;
    }


    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }
}
