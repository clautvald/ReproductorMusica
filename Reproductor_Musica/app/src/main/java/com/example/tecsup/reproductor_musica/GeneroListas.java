package com.example.tecsup.reproductor_musica;

import java.util.List;

public class GeneroListas {
    private String listaDeGeneros;
    String icons;

    public GeneroListas(String listaDeGeneros, String icons) {
        this.listaDeGeneros = listaDeGeneros;
        this.icons = icons;
    }

    public String getListaDeGeneros() {
        return listaDeGeneros;
    }

    public void setListaDeGeneros(String listaDeGeneros) {
        this.listaDeGeneros = listaDeGeneros;
    }

    public String getIcons() {
        return icons;
    }

    public void setIcons(String icons) {
        this.icons = icons;
    }
}
