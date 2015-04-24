package com.practicas_ds.cinemaquiz;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class GameActivity extends Activity {

    private int aciertos;
    private int fallos;
    private int id;
    private Pregunta pregunta;
    private Button option0;
    private Button option1;
    private Button option2;
    private Button option3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_activity);

        aciertos = fallos = id = 0;
        pregunta = Preguntas.getPregunta(id);

        option0 = (Button) findViewById(R.id.option0);
        option1 = (Button) findViewById(R.id.option1);
        option2 = (Button) findViewById(R.id.option2);
        option3 = (Button) findViewById(R.id.option3);

        actualizarVistas();

        option0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pregunta.getRespuestaCorrecta()==0) {
                    respuestaCorrecta();
                } else {
                    respuestaIncorrecta();
                }
            }
        });

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pregunta.getRespuestaCorrecta()==1) {
                    respuestaCorrecta();
                } else {
                    respuestaIncorrecta();
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pregunta.getRespuestaCorrecta()==2) {
                    respuestaCorrecta();
                } else {
                    respuestaIncorrecta();
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pregunta.getRespuestaCorrecta()==3) {
                    respuestaCorrecta();
                } else {
                    respuestaIncorrecta();
                }
            }
        });

    }

    private void actualizarVistas() {
        ImageView image = (ImageView) findViewById(R.id.image);
        image.setImageResource(R.drawable.generic_question);
        if(this.pregunta.getTipo()==1) {
            image.setImageResource(getImageId(this,this.pregunta.getRecurso()));
        }

        TextView pregunta = (TextView) findViewById(R.id.question);
        pregunta.setText(this.pregunta.getPregunta());

        option0.setText(this.pregunta.getRespuesta(0));
        option1.setText(this.pregunta.getRespuesta(1));
        option2.setText(this.pregunta.getRespuesta(2));
        option3.setText(this.pregunta.getRespuesta(3));
    }

    public static int getImageId(Context context, String imageName) {
        return context.getResources().getIdentifier("drawable/" + imageName, null, context.getPackageName());
    }

    private void respuestaCorrecta() {
        Toast.makeText(getApplicationContext(), "Has acertado :D", Toast.LENGTH_SHORT).show();
        id = (id + 1) % Preguntas.size();
        aciertos++;
        pregunta = Preguntas.getPregunta(id);
        actualizarVistas();
    }

    private void respuestaIncorrecta() {
        Toast.makeText(getApplicationContext(), "Te has equivocado :(", Toast.LENGTH_SHORT).show();
        id = (id + 1) % Preguntas.size();
        fallos++;
        pregunta = Preguntas.getPregunta(id);
        actualizarVistas();
    }
}
