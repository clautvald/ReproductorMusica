package com.example.tecsup.reproductor_musica;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Reproductor extends AppCompatActivity {
    MediaPlayer mp;
    ImageButton play;
    int posicion=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);
        play=findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iniciar(v);
            }
        });

    }
    public void destruir() {
        if(mp!=null){
            mp.release();
        }
    }
    public void iniciar(View v) {
        destruir();
        mp = MediaPlayer.create(this,R.raw.clocks);
        mp.start();

    }
    public void pausar(View v) {
        if (mp != null && mp.isPlaying()) {
            posicion = mp.getCurrentPosition();
            mp.pause();
        }
    }

    public void continuar(View v) {
        if (mp != null && mp.isPlaying() == false) {
            mp.seekTo(posicion);
            mp.start();
        }
    }

    public void detener(View v) {
        if (mp != null) {
            mp.stop();
            posicion = 0;
        }
    }


}
