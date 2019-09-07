package com.example.tecsup.reproductor_musica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
Button registro;
TextView nuevo_registro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registro = findViewById(R.id.registro);
        nuevo_registro = findViewById(R.id.txt_cta);

        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,Generos.class);
                startActivity(intent);
            }


        });
        nuevo_registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(MainActivity.this, Cuenta_nueva.class);
                startActivity(intent2);
            }
        });
    }
}
