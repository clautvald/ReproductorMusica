package com.example.tecsup.reproductor_musica;

public class GeneroListas {
    private String listaDeGeneros;
    private String imagenGenero;

    public GeneroListas(String listaDeGeneros, String imagenGenero) {
        this.listaDeGeneros = listaDeGeneros;
        this.imagenGenero = imagenGenero;
    }

    public String getListaDeGeneros() {
        return listaDeGeneros;
    }

    public void setListaDeGeneros(String listaDeGeneros) {
        this.listaDeGeneros = listaDeGeneros;
    }

    public String getImagenGenero() {
        return imagenGenero;
    }

    public void setImagenGenero(String imagenGenero) {
        this.imagenGenero = imagenGenero;
    }
}
