package com.example.tecsup.reproductor_musica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class Cuenta_nueva extends AppCompatActivity {
Button registro;
CheckBox terminos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cuenta_nueva);
        terminos = findViewById(R.id.check);
        terminos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(Cuenta_nueva.this, Terminos_condiciones.class);
                startActivity(intent1);
            }
        });
        registro = findViewById(R.id.registro);
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Cuenta_nueva.this, Generos.class);
                startActivity(intent);
                }

        });
        Toast.makeText(this,"¡Bienvenidx!",Toast.LENGTH_SHORT).show();
    }
}
