package com.example.tmdbapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tmdbapp.R;
import com.example.tmdbapp.interactor.Peliculas;

import java.util.ArrayList;

public class AdapterCaracteristicas extends RecyclerView.Adapter<AdapterCaracteristicas.ViewHolderPeliculas> {

    ArrayList<Peliculas> listPeliculas;
    private Context context;
    private LayoutInflater layoutInflater;

    public AdapterCaracteristicas(ArrayList<Peliculas> listPeliculas, Context context){
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.listPeliculas = listPeliculas;

    }

    @NonNull
    @Override
    public ViewHolderPeliculas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.activity_descripcion, null);
        return new AdapterCaracteristicas.ViewHolderPeliculas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPeliculas holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }



    public class ViewHolderPeliculas extends RecyclerView.ViewHolder {

        TextView tvnombre, tvfecha;
        ImageView imgc;

        public ViewHolderPeliculas(@NonNull View itemView) {

            super(itemView);
            tvnombre = itemView.findViewById(R.id.nombre3);
            tvfecha = itemView.findViewById(R.id.fecha3);
            imgc = itemView.findViewById(R.id.img3);



        }
    }
}
