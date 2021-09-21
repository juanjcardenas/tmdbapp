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

public class AdapterVotadas extends RecyclerView.Adapter<AdapterVotadas.ViewHolderVotadas> {

    ArrayList<Peliculas> listPeliculas;
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
        Glide.with(context).load("https://image.tmdb.org/t/p/w500"+peliculas.getPoster_path())
                .centerCrop().crossFade().diskCacheStrategy(DiskCacheStrategy.ALL).into(holder.ivimg2);
    }

    @Override
    public int getItemCount() {
        return listPeliculas.size();
    }

    public class ViewHolderVotadas extends RecyclerView.ViewHolder {

        TextView tvnombre2, tvfecha2, tvcalificacion;

        ImageView ivimg2;

        public ViewHolderVotadas(@NonNull View itemView) {
            super(itemView);
            tvnombre2 = itemView.findViewById(R.id.nombre2);
            tvfecha2 = itemView.findViewById(R.id.fecha2);
            tvcalificacion = itemView.findViewById(R.id.votacion);
            ivimg2 = itemView.findViewById(R.id.img2);
        }
    }
}
