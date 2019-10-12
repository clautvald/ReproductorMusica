package com.example.tecsup.reproductor_musica;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

public class GeneroPL_Adaptador extends RecyclerView.Adapter<GeneroPL_item> {
    List<GeneroListas> generoLista;
    LayoutInflater inflater;
    Context context;

    public GeneroPL_Adaptador(List<GeneroListas> generoLista, Context context) {
        this.generoLista = generoLista;
        this.context = context;
    }

    @NonNull
    @Override
    public GeneroPL_item onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = inflater.from(viewGroup.getContext()).inflate(R.layout.generopl,viewGroup,false);
        return new GeneroPL_item(v);
    }

    @Override
    public void onBindViewHolder(@NonNull GeneroPL_item holder, int position) {
        holder.genero.setText(generoLista.get(position).getListaDeGeneros());
        Glide.with(context).load(generoLista.get(position).icons).into(holder.fotoGenero);
    }

    @Override
    public int getItemCount() {
        return generoLista.size();
    }
}