package com.example.keroseno.podcast;

public class Podcast {
    //==============================================================================================
    // VARIABLES
    //==============================================================================================
    private String imagen, titulo, duracion, fecha, urlMp3;

    //==============================================================================================
    // CONSTRUCTORES
    //==============================================================================================
    public Podcast() {
    }

    public Podcast(String imagen, String titulo, String duracion, String fecha, String urlMp3) {
        this.imagen = imagen;
        this.titulo = titulo;
        this.duracion = duracion;
        this.fecha = fecha;
        this.urlMp3 = urlMp3;
    }

    //==============================================================================================
    // GETTERS Y SETTERS
    //==============================================================================================
    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getUrlMp3() {
        return urlMp3;
    }

    public void setUrlMp3(String urlMp3) {
        this.urlMp3 = urlMp3;
    }

    @Override
    public String toString() {
        return "URL imagen: " + this.imagen + "\n" +
                "Título: " + this.titulo + "\n" +
                "Duración: " + this.duracion + "\n" +
                "Fecha: " + this.fecha + "\n" +
                "URL MP3: " + this.urlMp3;
    }
}