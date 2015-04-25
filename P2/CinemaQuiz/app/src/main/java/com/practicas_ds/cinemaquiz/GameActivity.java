package com.practicas_ds.cinemaquiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class GameActivity extends Activity {

    private int aciertos; // número de aciertos
    private int fallos; // número de fallos
    private int id; // id de la pregunta actual
    private Pregunta pregunta; // pregunta actual
    private Button option0; // Botón primera opción
    private Button option1; // Botón segunda opción
    private Button option2; // Botón tercera opción
    private Button option3; // Botón cuarta opción
    private SoundPool soundPool; // Sonido de acierto o fallo
    private int spAciertoId; // Identificador de sonido de acierto
    private int spFalloId; // Identificador de sonido de fallo

    // Método llamado al crear la actividad
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

        Preguntas.shuffle(); // Se barajan las preguntas

        aciertos = fallos = id = 0; // se inicializan las variables a 0
        pregunta = Preguntas.getPregunta(id); // se escoge la pregunta número id

        // Se buscan los botones
        option0 = (Button) findViewById(R.id.option0);
        option1 = (Button) findViewById(R.id.option1);
        option2 = (Button) findViewById(R.id.option2);
        option3 = (Button) findViewById(R.id.option3);

        // Se crean los sonidos de acierto y fallo
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { // Usa el nuevo constructor
            AudioAttributes aa = new AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setMaxStreams(2)
                    .setAudioAttributes(aa)
                    .build();
            spAciertoId = soundPool.load(this, R.raw.correct, 1);
            spFalloId = soundPool.load(this, R.raw.wrong, 1);
        } else { // Usa un constructor deprecated a partir de Lollipop pero válido en versiones anteriores
            soundPool = new SoundPool(2, AudioManager.STREAM_NOTIFICATION, 1);
            spAciertoId = soundPool.load(this, R.raw.correct, 1);
            spFalloId = soundPool.load(this, R.raw.wrong, 1);
        }

        actualizarVistas(); // Se actualizan las vistas con la pregunta correspondiente

        // Listener de los botones
        option0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pregunta.getRespuestaCorrecta()==0) { // Acierto
                    // Se colorea el botón de verde
                    option0.setBackgroundResource(R.drawable.btn_success);
                    option0.setTextColor(getResources().getColor(R.color.buttonTextColorWhite));
                    respuestaCorrecta();
                } else { // Fallo
                    // Se colorea el botón de rojo
                    option0.setBackgroundResource(R.drawable.btn_error);
                    option0.setTextColor(getResources().getColor(R.color.buttonTextColorWhite));
                    respuestaIncorrecta();
                }
            }
        });

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pregunta.getRespuestaCorrecta()==1) { // Acierto
                    // Se colorea el botón de verde
                    option1.setBackgroundResource(R.drawable.btn_success);
                    option1.setTextColor(getResources().getColor(R.color.buttonTextColorWhite));
                    respuestaCorrecta();
                } else { // Fallo
                    // Se colorea el botón de rojo
                    option1.setBackgroundResource(R.drawable.btn_error);
                    option1.setTextColor(getResources().getColor(R.color.buttonTextColorWhite));
                    respuestaIncorrecta();
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pregunta.getRespuestaCorrecta()==2) { // Acierto
                    // Se colorea el botón de verde
                    option2.setBackgroundResource(R.drawable.btn_success);
                    option2.setTextColor(getResources().getColor(R.color.buttonTextColorWhite));
                    respuestaCorrecta();
                } else { // Fallo
                    // Se colorea el botón de rojo
                    option2.setBackgroundResource(R.drawable.btn_error);
                    option2.setTextColor(getResources().getColor(R.color.buttonTextColorWhite));
                    respuestaIncorrecta();
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pregunta.getRespuestaCorrecta()==3) { // Acierto
                    // Se colorea el botón de verde
                    option3.setBackgroundResource(R.drawable.btn_success);
                    option3.setTextColor(getResources().getColor(R.color.buttonTextColorWhite));
                    respuestaCorrecta();
                } else { // Fallo
                    // Se colorea el botón de rojo
                    option3.setBackgroundResource(R.drawable.btn_error);
                    option3.setTextColor(getResources().getColor(R.color.buttonTextColorWhite));
                    respuestaIncorrecta();
                }
            }
        });

    }

    // Método para actualizar la actividad cada vez que se cambia de pregunta
    private void actualizarVistas() {
        // Se da el estilo de botón predeterminado a todos los botones
        option0.setBackgroundResource(R.drawable.btn_default);
        option0.setTextColor(getResources().getColor(R.color.buttonTextColor));
        option1.setBackgroundResource(R.drawable.btn_default);
        option1.setTextColor(getResources().getColor(R.color.buttonTextColor));
        option2.setBackgroundResource(R.drawable.btn_default);
        option2.setTextColor(getResources().getColor(R.color.buttonTextColor));
        option3.setBackgroundResource(R.drawable.btn_default);
        option3.setTextColor(getResources().getColor(R.color.buttonTextColor));

        // Se cargan la imagen y el RelativeLayout donde se encuentran los controles de la música
        ImageView image = (ImageView) findViewById(R.id.image);
        RelativeLayout music = (RelativeLayout) findViewById(R.id.music);

        if(this.pregunta.getTipo() == 0 || this.pregunta.getTipo() == 1) { // Si la pregunta es básica o con imagen se carga esta
            if (this.pregunta.getTipo() == 1) { // Si es tipo pregunta con imagen se carga el recurso
                image.setImageResource(getImageId(this, this.pregunta.getRecurso()));
            } else { // en caso contrario se carga la imagen genérica
                image.setImageResource(R.drawable.generic_question);
            }
            music.setVisibility(View.GONE); // Los controles de la música desaparecen
        } else { // Si la pregunta es de música
            image.setVisibility(View.GONE); // La imagen desaparece
        }

        // Se carga la pregunta y se le da el texto correspondiente
        TextView pregunta = (TextView) findViewById(R.id.question);
        pregunta.setText(this.pregunta.getPregunta());

        // Se carga el texto en todos los botones
        option0.setText(this.pregunta.getRespuesta(0));
        option1.setText(this.pregunta.getRespuesta(1));
        option2.setText(this.pregunta.getRespuesta(2));
        option3.setText(this.pregunta.getRespuesta(3));
    }

    // Método para obtener el id de un recurso en forma de imagen a partir de un String
    private int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }

    // Método que se activa cuando la respuesta pulsada es correcta
    private void respuestaCorrecta() {
        // Se actualizan las variables correspondientes
        aciertos++;
        id++;

        // String auxiliares que se mostrarán en el mensaje
        String successMessage = getString(R.string.num_success) + aciertos;
        String errorsMessage = getString(R.string.num_errors) + fallos;

        // Sonido de acierto
        soundPool.play(spAciertoId, 0.25f, 0.25f, 1, 0, 1);

        // Se muestra un AlertDialog con los resultados parciales y un botón para continuar
        new AlertDialog.Builder(this)
                .setTitle(R.string.success_message)
                .setMessage(successMessage + "\n" + errorsMessage) // Mensaje con los aciertos y fallos que se llevan
                .setPositiveButton(R.string.continue_game, new DialogInterface.OnClickListener() { // Botón continuar
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (id == Preguntas.size()) { // Se ha respondido todas las preguntas
                            juegoCompletado();
                        } else { // Se pasa a la siguiente pregunta
                            siguientePregunta();
                        }
                    }
                })
                .setCancelable(false) // Pulsar fuera del AlertDialog no lo desactiva
                .show();
    }

    // Método que se activa cuando la respuesta pulsada es correcta
    private void respuestaIncorrecta() {
        // Se actualizan las variables correspondientes
        fallos++;
        id++;

        // String auxiliares que se mostrarán en el mensaje
        String successMessage = getString(R.string.num_success) + aciertos;
        String errorsMessage = getString(R.string.num_errors) + fallos;

        // Sonido de fallo
        soundPool.play(spFalloId, 0.25f, 0.25f, 1, 0, 1);

        // Se muestra un AlertDialog con los resultados parciales y un botón para continuar
        new AlertDialog.Builder(this)
                .setTitle(R.string.error_message)
                .setMessage(successMessage + "\n" + errorsMessage) // Mensaje con los aciertos y fallos que se llevan
                .setNegativeButton(R.string.exit_game, new DialogInterface.OnClickListener() { // Botón salir
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finalizarPartida(); // finaliza la partida
                    }
                })
                .setPositiveButton(R.string.continue_game, new DialogInterface.OnClickListener() { // Botón continuar
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (id == Preguntas.size()) { // Se ha respondido todas las preguntas
                            juegoCompletado();
                        } else { // Se pasa a la siguiente pregunta
                            siguientePregunta();
                        }
                    }
                })
                .setCancelable(false) // Pulsar fuera del AlertDialog no lo desactiva
                .show();
    }

    // Método para cambiar de pregunta y actualizar los campos de la actividad
    private void siguientePregunta() {
        pregunta = Preguntas.getPregunta(id);
        actualizarVistas();
    }

    // Método que se activa cuando se finaliza la partida
    private void finalizarPartida() {
        finish();
    }

    // Método que se activa cuando se responden todas las preguntas
    private void juegoCompletado() {
        // String auxiliares que se mostrarán en el mensaje
        String finishMessage = getString(R.string.finish_message);
        String successMessage = getString(R.string.num_success) + aciertos;
        String errorsMessage = getString(R.string.num_errors) + fallos;

        // Se muestra un AlertDialog con los resultados finales y un botón para volver al menu principal
        new AlertDialog.Builder(this)
                .setTitle(R.string.finish_title)
                .setMessage(finishMessage + "\n\n" + successMessage + "\n" + errorsMessage) // Mensaje de despedida con los aciertos y fallos que se llevan
                .setPositiveButton(R.string.exit_game, new DialogInterface.OnClickListener() { // Botón salir
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finalizarPartida(); // Se finaliza la partida
                    }
                })
                .setCancelable(false) // Pulsar fuera del AlertDialog no lo desactiva
                .show();
    }
}
