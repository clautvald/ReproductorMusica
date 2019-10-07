package com.example.tecsup.reproductor_musica;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class Principal extends AppCompatActivity {
    BottomNavigationView bottonNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        bottonNav = findViewById(R.id.bottom_nav);
        bottonNav.setOnNavigationItemSelectedListener(navListener);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener(){

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            Fragment selectedFragment = null;
            switch (menuItem.getItemId()){
                case R.id.nav_inicio:
                    //selectedFragment = new Generos();
                    break;

                case R.id.nav_Buscar:
                    selectedFragment = new Generos();
                    break;

                case R.id.nav_favoritos:
                    //selectedFragment = new Generos();
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, selectedFragment).commit();
            return false;
        }
    };
}
