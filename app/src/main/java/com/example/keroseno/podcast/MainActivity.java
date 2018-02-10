package com.example.keroseno.podcast;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;

/**
 * Clase principal de la lectura del podcast Palabra de Hacker.
 *
 * URL RSS: http://www.ivoox.com/palabra-hacker_fg_f1266057_filtro_1.xml
 */
public class MainActivity extends AppCompatActivity {
    //==============================================================================================
    // CONSTANTES
    //==============================================================================================
    private static final String URL_RSS = "http://www.ivoox.com/palabra-hacker_fg_f1266057_filtro_1.xml";

    //==============================================================================================
    // VARIABLES
    //==============================================================================================
    private ListView lista;
    private Podcasts podcasts;
    private AdaptadorPantalla adaptadorPantalla;
    private static MediaPlayer reproductorMultimedia;
    private String urlMp3;
    private CargarXML cargadorXml;

    //==============================================================================================
    // MÉTODOS SOBREESCRITOS
    //==============================================================================================
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Se declara el reproductor de música.
        reproductorMultimedia = new MediaPlayer();

        // Se asocia la lista a su elemento en la vista.
        lista = findViewById(R.id.lista_podcast);

        // Se crea el hilo (AsyncTask) que cargará los datos del XML.
        cargadorXml = new CargarXML();
        cargadorXml.execute(URL_RSS);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> vistaAdaptador, View vista, int indice, long l) {
                try {
                    if (reproductorMultimedia.isPlaying()) {
                        reproductorMultimedia.reset();
                    }

                    urlMp3 = podcasts.elemento(indice).getUrlMp3();
                    reproductorMultimedia.setAudioStreamType(AudioManager.STREAM_MUSIC);
                    reproductorMultimedia.setDataSource(urlMp3);
                    reproductorMultimedia.prepare();
                    reproductorMultimedia.start();

                    Toast.makeText(MainActivity.this, podcasts.elemento(indice).getTitulo().toString(), Toast.LENGTH_SHORT).show();

                } catch (IOException e) {
                    reproductorMultimedia.stop();
                    Toast.makeText(MainActivity.this, "Error al reproducir: " + e.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    //==============================================================================================
    // ASYNCTASK - TAREA ASÍNCRONA
    //==============================================================================================
    /**
     * Clase que crea una tarea asíncrona que carga un XML en segundo plano.
     */
    private class CargarXML extends AsyncTask<String, Integer, Boolean> {

        protected Boolean doInBackground(String... params) {
            RSSParserSAX rssParserSax;

            rssParserSax = new RSSParserSAX(params[0]);

            podcasts = rssParserSax.parse();

            return true;
        }

        protected void onPostExecute(Boolean result) {
            // Se inicia y llena la lista.
            adaptadorPantalla = new AdaptadorPantalla(MainActivity.this, podcasts);
            lista.setAdapter(adaptadorPantalla);
        }
    }
}