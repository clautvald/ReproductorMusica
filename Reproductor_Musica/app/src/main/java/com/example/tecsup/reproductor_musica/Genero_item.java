package com.example.tecsup.reproductor_musica;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Genero_item extends RecyclerView.ViewHolder {
    TextView genero;
    ImageView fotoGenero;

    public Genero_item(@NonNull View itemView) {
        super(itemView);
        genero = itemView.findViewById(R.id.txt_genero);
        fotoGenero = itemView.findViewById(R.id.iv_ImaGenero);

    }
}
