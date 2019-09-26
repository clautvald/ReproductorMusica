package com.example.tecsup.reproductor_musica;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

public class Genero_Adaptador extends RecyclerView.Adapter<Genero_item> {
    public List<GeneroListas> generoLista;
    LayoutInflater inflater;
    Context context;
    Drawable imagen;

    public Genero_Adaptador(List<GeneroListas> generoLista, Context context) {
        this.generoLista = generoLista;
        this.context = context;
    }

    /*public class ViewHolder extends  RecyclerView.ViewHolder{
        private Button txt_genero;
        Context context;
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);
            txt_genero = itemView.findViewById(R.id.txt_genero);
            txt_genero.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,Listas_genero.class);
                    context.startActivity(intent);
                }
            });
        }

    }*/

    @NonNull
    @Override
    public Genero_item onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = inflater.inflate(R.layout.genero,viewGroup,false);
        return new Genero_item(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Genero_item holder, int position) {
        holder.genero.setText(generoLista.get(position).getListaDeGeneros());
        //Glide.with(context).load(generoLista.get(position).getImagenGenero()).into(imagen);
        holder.genero.setBackground(imagen);
    }

    @Override
    public int getItemCount() {
        return generoLista.size();
    }
}
