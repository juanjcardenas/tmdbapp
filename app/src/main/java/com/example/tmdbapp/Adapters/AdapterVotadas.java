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

public class AdapterVotadas extends RecyclerView.Adapter<AdapterVotadas.ViewHolderVotadas> {

    private ArrayList<Peliculas> listPeliculas;
    private Context context;
    private LayoutInflater layoutInflater;

    public AdapterVotadas(ArrayList<Peliculas> listPeliculas, Context context) {

        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.listPeliculas = listPeliculas;
    }

    @NonNull
    @Override
    public AdapterVotadas.ViewHolderVotadas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_votadas, null);
        return  new AdapterVotadas.ViewHolderVotadas(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderVotadas holder, int position) {
        Peliculas peliculas = listPeliculas.get(position);
        holder.tvnombre2.setText(listPeliculas.get(position).getOriginal_title());
        holder.tvfecha2.setText(listPeliculas.get(position).getRelease_date());
        holder.tvcalificacion.setText(String.valueOf(listPeliculas.get(position).getVote_count()));
        holder.Url = "https://image.tmdb.org/t/p/w500" + listPeliculas.get(position).getPoster_path();
        Glide.with(context).load(holder.Url).diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.ivimg2);

        String nombre = peliculas.getOriginal_title();
        String fecha = peliculas.getRelease_date();




        holder.votadas.setOnClickListener(new View.OnClickListener() {
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

    public class ViewHolderVotadas extends RecyclerView.ViewHolder {

        TextView tvnombre2, tvfecha2, tvcalificacion;
        LinearLayout votadas;
        ImageView ivimg2;
        String Url, Urldescripcion;

        public ViewHolderVotadas(@NonNull View itemView) {

            super(itemView);
            tvnombre2 = itemView.findViewById(R.id.nombre2);
            tvfecha2 = itemView.findViewById(R.id.fecha2);
            tvcalificacion = itemView.findViewById(R.id.votacion);
            ivimg2 = itemView.findViewById(R.id.img2);
            votadas = itemView.findViewById(R.id.votadas);
        }
    }
}
