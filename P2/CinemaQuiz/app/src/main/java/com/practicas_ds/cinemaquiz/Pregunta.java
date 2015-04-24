package com.practicas_ds.cinemaquiz;

import java.util.Random;

public class Pregunta {

    private String pregunta;
    private int respuestaCorrecta;
    private String[] respuestas;
    private int tipo;
    private String recurso;

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(int respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getRecurso() {
        return recurso;
    }

    public void setRecurso(String recurso) {
        this.recurso = recurso;
    }

    public String[] getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(String[] respuestas) {
        this.respuestas = respuestas;
    }

    public String getRespuesta(int i) {
        return respuestas[i];
    }

    public void setRespuesta(int i, String respuesta) {
        respuestas[i] = respuesta;
    }

    public Pregunta(String pregunta, String respuestaCorrecta,
                    String respuestaIncorrecta1, String respuestaIncorrecta2,
                    String respuestaIncorrecta3, int tipo, String recurso) {
        this.pregunta = pregunta;
        this.tipo = tipo;
        this.recurso = recurso;
        respuestas = new String[4];

        Random random = new Random();
        int number = random.nextInt(4);

        this.respuestaCorrecta = number;
        respuestas[this.respuestaCorrecta] = respuestaCorrecta;

        number = random.nextInt(4);
        while(respuestas[number] != null) {
            number = (number + 1) % 4;
        }
        respuestas[number] = respuestaIncorrecta1;

        number = random.nextInt(4);
        while(respuestas[number] != null) {
            number = (number + 1) % 4;
        }
        respuestas[number] = respuestaIncorrecta2;

        number = random.nextInt(4);
        while(respuestas[number] != null) {
            number = (number + 1) % 4;
        }
        respuestas[number] = respuestaIncorrecta3;
    }

}