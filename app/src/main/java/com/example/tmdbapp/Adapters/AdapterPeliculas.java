package com.example.tmdbapp.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.tmdbapp.R;
import com.example.tmdbapp.interactor.Peliculas;
import com.example.tmdbapp.views.Descripcion;

import java.util.ArrayList;

public class AdapterPeliculas extends RecyclerView.Adapter<AdapterPeliculas.ViewHolderPeliculas> {

    private ArrayList <Peliculas> listPeliculas;
    private Context context;
    private LayoutInflater layoutInflater;


    public AdapterPeliculas(ArrayList<Peliculas> listPeliculas,Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.listPeliculas = listPeliculas;
    }
    @NonNull
    @Override
    public AdapterPeliculas.ViewHolderPeliculas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_peliculas, null);
        return new AdapterPeliculas.ViewHolderPeliculas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPeliculas holder, int position){
        Peliculas peliculas = listPeliculas.get(position);
        holder.tvnombre.setText(listPeliculas.get(position).getOriginal_title());
        holder.tvfecha.setText(listPeliculas.get(position).getRelease_date());
        holder.Url = "https://image.tmdb.org/t/p/w500" + listPeliculas.get(position).getPoster_path();
        Glide.with(context).load(holder.Url).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.ivimg);

        String nombre = peliculas.getOriginal_title();
        String fecha = peliculas.getRelease_date();



        holder.populares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                holder.Urldescripcion = "https://image.tmdb.org/t/p/w500"+ listPeliculas.get(position).getPoster_path();
                Intent intent = new Intent(context, Descripcion.class);
                intent.putExtra("nombre", nombre);
                intent.putExtra("fecha", fecha);
                intent.putExtra("img", holder.Urldescripcion);

                context.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return listPeliculas.size();
    }

    public static class ViewHolderPeliculas extends RecyclerView.ViewHolder {

        TextView tvnombre, tvfecha;
        ImageView ivimg;
        LinearLayout populares;
        String Url;
        String Urldescripcion;

        public ViewHolderPeliculas(@NonNull View itemView) {

            super(itemView);
            tvnombre = itemView.findViewById(R.id.nombre);
            tvfecha = itemView.findViewById(R.id.fecha);
            ivimg = itemView.findViewById(R.id.img);
            populares = itemView.findViewById(R.id.populares);
        }
    }
}
