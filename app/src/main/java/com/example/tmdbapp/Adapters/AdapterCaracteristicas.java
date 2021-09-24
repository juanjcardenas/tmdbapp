package com.example.tmdbapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tmdbapp.R;
import com.example.tmdbapp.interactor.Peliculas;

import java.util.ArrayList;

public class AdapterCaracteristicas extends RecyclerView.Adapter<AdapterCaracteristicas.ViewHolderDescripcion> {

    private ArrayList<Peliculas> listcaracteristicas;
    private Context context;
    private LayoutInflater layoutInflater;



    public AdapterCaracteristicas(ArrayList<Peliculas> listcaracteristicas, Context context){

        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
        this.listcaracteristicas = listcaracteristicas;

    }

    @NonNull
    @Override
    public AdapterCaracteristicas.ViewHolderDescripcion onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_descripcion, null);
        return  new AdapterCaracteristicas.ViewHolderDescripcion(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCaracteristicas.ViewHolderDescripcion holder, int position) {
        holder.informacion1.setText(listcaracteristicas.get(position).getOriginal_title());
        holder.informacion2.setText(listcaracteristicas.get(position).getOverview());
    }

    @Override
    public int getItemCount() {
        return listcaracteristicas.size();
    }

    public class ViewHolderDescripcion extends RecyclerView.ViewHolder {
        private TextView informacion1, informacion2;
        public ViewHolderDescripcion(@NonNull View itemView) {


            super(itemView);
            informacion1= itemView.findViewById(R.id.info1);
            informacion2= itemView.findViewById(R.id.info2);
        }
    }
}
