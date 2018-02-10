package com.example.keroseno.podcast;

import java.util.ArrayList;

public class Podcasts {
    //==============================================================================================
    // VARIABLES
    //==============================================================================================
    private ArrayList<Podcast> arrayPodcasts;

    //==============================================================================================
    // CONSTRUCTOR
    //==============================================================================================
    public Podcasts() {
        arrayPodcasts = new ArrayList<Podcast>();
    }

    //==============================================================================================
    // MÉTODOS
    //==============================================================================================
    public Podcast elemento(int indice) {
        Podcast podcast;

        podcast = arrayPodcasts.get(indice);

        return podcast;
    }

    public void anhadirPodcast(Podcast podcast) {
        arrayPodcasts.add(podcast);
    }

    public int tamanho() {
        int tamanho;

        tamanho = arrayPodcasts.size();

        return tamanho;
    }
}
