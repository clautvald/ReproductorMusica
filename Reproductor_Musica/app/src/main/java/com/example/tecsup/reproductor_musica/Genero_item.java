package com.example.tecsup.reproductor_musica;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class Genero_item extends RecyclerView.ViewHolder {
    Button genero;

    public Genero_item(@NonNull View itemView) {
        super(itemView);
        genero = itemView.findViewById(R.id.btn_genero);

    }
}
