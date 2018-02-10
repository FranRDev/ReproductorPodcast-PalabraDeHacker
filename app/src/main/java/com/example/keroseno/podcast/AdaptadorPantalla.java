package com.example.keroseno.podcast;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class AdaptadorPantalla extends BaseAdapter {
    //==============================================================================================
    // ATRIBUTOS ADAPTADOR
    //==============================================================================================
    private LayoutInflater inflador; // Crea Layouts a partir del XML.
    private Podcasts podcasts;
    private Context contexto;

    //==============================================================================================
    // ELEMENTOS PANTALLA
    //==============================================================================================
    private ImageView imagenPodcast;
    private TextView nombrePodcast, duracionPodcast, fechaPodcast;

    //==============================================================================================
    // CONSTRUCTOR
    //==============================================================================================
    public AdaptadorPantalla(Context contexto, Podcasts podcasts) {
        this.contexto = contexto;
        this.podcasts = podcasts;
        this.inflador = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    //==============================================================================================
    // MÉTODOS SOBREESCRITOS
    //==============================================================================================
    @Override
    public int getCount() {
        int tamanho;

        tamanho = podcasts.tamanho();

        return tamanho;
    }

    @Override
    public Object getItem(int indice) {
        Object podcast;

        podcast = podcasts.elemento(indice);

        return podcast;
    }

    @Override
    public long getItemId(int indice) {
        return indice;
    }

    /**
     * Método encargado de mostrar los elementos en pantalla.
     * @param indice
     * @param vista
     * @param vistaGrupo
     * @return
     */
    @Override
    public View getView(int indice, View vista, ViewGroup vistaGrupo) {
        Podcast podcast = podcasts.elemento(indice);

        if (vista == null) {
            vista = inflador.inflate(R.layout.elemento_lista, null);
        }

        imagenPodcast = vista.findViewById(R.id.imagen_podcast);
        nombrePodcast = vista.findViewById(R.id.nombre_podcast);
        duracionPodcast = vista.findViewById(R.id.duracion_podcast);
        fechaPodcast = vista.findViewById(R.id.fecha_podcast);

        String urlImagen =  podcast.getImagen();
        Glide
                .with(contexto)
                .load(urlImagen)
                .into(imagenPodcast);
        nombrePodcast.setText(podcast.getTitulo());
        duracionPodcast.setText(podcast.getDuracion());
        fechaPodcast.setText(podcast.getFecha());

        return vista;
    }
}
