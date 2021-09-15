package com.example.tmdbapp.Adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tmdbapp.interactor.Peliculas;

import java.util.ArrayList;

public class AdapterVotadas extends RecyclerView.Adapter<AdapterVotadas.ViewHolderVotadas> {
    ArrayList<Peliculas> listPeliculas;

    public AdapterVotadas(ArrayList<Peliculas> listPeliculas) {
        this.listPeliculas = listPeliculas;
    }

    @NonNull
    @Override
    public ViewHolderVotadas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderVotadas holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderVotadas extends RecyclerView.ViewHolder {
        public ViewHolderVotadas(@NonNull View itemView) {
            super(itemView);
        }
    }
}
