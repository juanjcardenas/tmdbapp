package com.example.tmdbapp.views;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
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

public class PrincipalActivityView extends AppCompatActivity implements PrincipalView {

     private PrincipalPresenter presenter;
     private RecyclerView recyclerView, recyclerView2;
     private AdapterPeliculas adapterPeliculas;
     private AdapterVotadas adapterVotadas;
     private TextView emensaje;
     private EditText buscador1;
     private ImageView lupa;
     private Button recargarI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        recyclerView = findViewById(R.id.peliculas);
        recyclerView2 = findViewById(R.id.peliculas2);
        buscador1  = findViewById(R.id.buscador);
        emensaje = findViewById(R.id.menerror);
        lupa = findViewById(R.id.lupa);
        recargarI = findViewById(R.id.recargar);
        presenter = new PrincipalPresentersImpl(this);
        recyclerView.setVisibility(View.VISIBLE);
        recyclerView2.setVisibility(View.VISIBLE);
        recargarI.setVisibility(View.VISIBLE);
        obtenerVotadas();
        obtenerPopulares();


        lupa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!buscador1.getText().toString().isEmpty())
                        enviarPeliculas(buscador1.getText().toString());
                else
                    obtenerPopulares();
            }
        });

        recargarI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    @Override
    public void mostrarVotadas(ArrayList<Peliculas> peliculas) {
        adapterVotadas = new AdapterVotadas(peliculas, this);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        emensaje.setVisibility(View.GONE);
        recargarI.setVisibility(View.GONE);
        recyclerView2.setAdapter(adapterVotadas);
    }

    @Override
    public void mostrarPopulares(ArrayList<Peliculas> peliculas) {
        adapterPeliculas = new AdapterPeliculas(peliculas, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        emensaje.setVisibility(View.GONE);
        recargarI.setVisibility(View.GONE);
        recyclerView.setAdapter(adapterPeliculas);
        recyclerView.setLayoutManager((new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)));

    }

    @Override
    public void mostrarPeliculas(ArrayList<Peliculas> peliculas) {
        adapterPeliculas = new AdapterPeliculas(peliculas, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        emensaje.setVisibility(View.GONE);
        recargarI.setVisibility(View.GONE);
        recyclerView.setAdapter(adapterPeliculas);
        recyclerView.setLayoutManager((new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)));
    }

    @Override
    public void ocultarPeliculas() {
        recyclerView.setVisibility(View.GONE);
        recyclerView2.setVisibility(View.GONE);

    }

    @Override
    public void enviarPeliculas(String q) {

        presenter.obtenerPeliculas(q);
        System.out.println("se envio Q");
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

}
