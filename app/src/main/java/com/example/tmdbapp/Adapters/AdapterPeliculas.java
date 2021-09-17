package com.example.tmdbapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.tmdbapp.R;
import com.example.tmdbapp.interactor.Peliculas;

import java.util.ArrayList;

public class AdapterPeliculas extends RecyclerView.Adapter<AdapterPeliculas.ViewHolderPeliculas> {

    ArrayList<Peliculas> listPeliculas;
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
    public void onBindViewHolder(@NonNull AdapterPeliculas.ViewHolderPeliculas holder, int position) {
        Peliculas peliculas = listPeliculas.get(position);
        holder.tvnombre.setText(listPeliculas.get(position).getOriginal_title());
        holder.tvfecha.setText(listPeliculas.get(position).getRelease_date());
        Glide.with(context).load("https://image.tmdb.org/t/p/w500"+peliculas.getPoster_path())
                .centerCrop().crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.ivimg);

    }

    @Override
    public int getItemCount() {
        return listPeliculas.size();
    }

    public static class ViewHolderPeliculas extends RecyclerView.ViewHolder {

        TextView tvnombre, tvfecha;
        ImageView ivimg;

        public ViewHolderPeliculas(@NonNull View itemView) {

            super(itemView);
            tvnombre = itemView.findViewById(R.id.nombre);
            tvfecha = itemView.findViewById(R.id.fecha);
            ivimg = itemView.findViewById(R.id.img);
        }
    }
}
