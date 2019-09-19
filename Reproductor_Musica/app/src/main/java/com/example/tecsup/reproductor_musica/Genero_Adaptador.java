package com.example.tecsup.reproductor_musica;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Genero_Adaptador extends RecyclerView.Adapter<Genero_Adaptador.ViewHolder> {


    public class ViewHolder extends  RecyclerView.ViewHolder{
        private TextView txt_genero;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt_genero = itemView.findViewById(R.id.txt_genero);
        }

    }

    public List<generoListas> generoLista;

    public Genero_Adaptador(List<generoListas> generoLista) {
        this.generoLista = generoLista;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.genero,parent,false);
        ViewHolder viewholder = new ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txt_genero.setText(generoLista.get(position).getListaDeGeneros());
    }

    @Override
    public int getItemCount() {
        return generoLista.size();
    }
}
