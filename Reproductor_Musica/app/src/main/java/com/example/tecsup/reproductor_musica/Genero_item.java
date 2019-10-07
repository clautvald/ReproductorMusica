package com.example.tecsup.reproductor_musica;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.nio.channels.InterruptedByTimeoutException;

public class Genero_item extends RecyclerView.ViewHolder {
    TextView genero;
    ImageView fotoGenero;
    CardView cv;
    Context context;

    public Genero_item(@NonNull View itemView, Context c) {
        super(itemView);
        this.context = c;
        genero = itemView.findViewById(R.id.txt_genero);
        fotoGenero = itemView.findViewById(R.id.iv_ImaGenero);
        cv = itemView.findViewById(R.id.cv_CardView);

        cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(context,Listas_genero.class);
                //context.startActivity(intent);

            }
        });
    }
}
