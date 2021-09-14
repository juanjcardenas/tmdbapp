package com.example.tmdbapp.Adapters;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapterPeliculas extends RecyclerView.Adapter<AdapterPeliculas.ViewHolderPeliculas> {
    @NonNull
    @Override
    public AdapterPeliculas.ViewHolderPeliculas onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterPeliculas.ViewHolderPeliculas holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderPeliculas extends RecyclerView.ViewHolder {
        public ViewHolderPeliculas(@NonNull View itemView) {
            super(itemView);
        }
    }
}
