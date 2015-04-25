package com.practicas_ds.cinemaquiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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
        Preguntas.shuffle();

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
                    option0.setBackgroundResource(R.drawable.btn_success);
                    option0.setTextColor(getResources().getColor(R.color.buttonTextColorWhite));
                    respuestaCorrecta();
                } else {
                    option0.setBackgroundResource(R.drawable.btn_error);
                    option0.setTextColor(getResources().getColor(R.color.buttonTextColorWhite));
                    respuestaIncorrecta();
                }
            }
        });

        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pregunta.getRespuestaCorrecta()==1) {
                    option1.setBackgroundResource(R.drawable.btn_success);
                    option1.setTextColor(getResources().getColor(R.color.buttonTextColorWhite));
                    respuestaCorrecta();
                } else {
                    option1.setBackgroundResource(R.drawable.btn_error);
                    option1.setTextColor(getResources().getColor(R.color.buttonTextColorWhite));
                    respuestaIncorrecta();
                }
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pregunta.getRespuestaCorrecta()==2) {
                    option2.setBackgroundResource(R.drawable.btn_success);
                    option2.setTextColor(getResources().getColor(R.color.buttonTextColorWhite));
                    respuestaCorrecta();
                } else {
                    option2.setBackgroundResource(R.drawable.btn_error);
                    option2.setTextColor(getResources().getColor(R.color.buttonTextColorWhite));
                    respuestaIncorrecta();
                }
            }
        });

        option3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pregunta.getRespuestaCorrecta()==3) {
                    option3.setBackgroundResource(R.drawable.btn_success);
                    option3.setTextColor(getResources().getColor(R.color.buttonTextColorWhite));
                    respuestaCorrecta();
                } else {
                    option3.setBackgroundResource(R.drawable.btn_error);
                    option3.setTextColor(getResources().getColor(R.color.buttonTextColorWhite));
                    respuestaIncorrecta();
                }
            }
        });

    }

    private void actualizarVistas() {
        option0.setBackgroundResource(R.drawable.btn_default);
        option0.setTextColor(getResources().getColor(R.color.buttonTextColor));
        option1.setBackgroundResource(R.drawable.btn_default);
        option1.setTextColor(getResources().getColor(R.color.buttonTextColor));
        option2.setBackgroundResource(R.drawable.btn_default);
        option2.setTextColor(getResources().getColor(R.color.buttonTextColor));
        option3.setBackgroundResource(R.drawable.btn_default);
        option3.setTextColor(getResources().getColor(R.color.buttonTextColor));

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
        aciertos++;
        new AlertDialog.Builder(this)
                .setTitle(R.string.success_message)
                //.setMessage(R.string.num_success + Integer.toString(aciertos) + "\n" + R.string.num_errors + Integer.toString(fallos))
                .setPositiveButton(R.string.continue_game, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        id = (id + 1) % Preguntas.size();
                        pregunta = Preguntas.getPregunta(id);
                        actualizarVistas();
                    }
                })
                .setCancelable(false)
                .show();
    }

    private void respuestaIncorrecta() {
        fallos++;
        new AlertDialog.Builder(this)
                .setTitle(R.string.error_message)
                //.setMessage(R.string.num_success + Integer.toString(aciertos) + "\n" + R.string.num_errors + Integer.toString(fallos))
                .setNegativeButton(R.string.exit_game,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setPositiveButton(R.string.continue_game, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        id = (id + 1) % Preguntas.size();
                        pregunta = Preguntas.getPregunta(id);
                        actualizarVistas();
                    }
                })
                .setCancelable(false)
                .show();
    }
}
