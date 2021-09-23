package com.example.tmdbapp.views;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.tmdbapp.R;
import com.example.tmdbapp.interactor.Peliculas;

import java.util.ArrayList;

public class Descripcion extends AppCompatActivity {

    private TextView nombre, fecha;
    private ImageView img, atras;
    private Bundle bundle;
    private Context context;
    private ArrayList<Peliculas> listPeliculas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);

        bundle = getIntent().getExtras();
        atras = findViewById(R.id.atras);
        img = findViewById(R.id.img3);
        nombre = findViewById(R.id.nombre3);
        fecha = findViewById(R.id.fecha3);


        String nombreDescripcion = getIntent().getStringExtra("nombre");
        String fechaDescripcion = getIntent().getStringExtra("fecha");

        img.setImageResource(bundle.getInt("img"));
        String imgobtenido = bundle.getString("img");
        Glide.with(this).load(imgobtenido).into(img);


        nombre.setText(nombreDescripcion);
        fecha.setText(fechaDescripcion);


        atras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}