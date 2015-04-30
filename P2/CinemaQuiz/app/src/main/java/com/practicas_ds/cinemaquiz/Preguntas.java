package com.practicas_ds.cinemaquiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Preguntas {
    protected static List<Pregunta> vectorPreguntas;

    public Preguntas() {
    }

    static void setPreguntas(ArrayList<Pregunta> preguntas) {
        vectorPreguntas = preguntas;
    }

    static void shuffle() {
        Collections.shuffle(vectorPreguntas);
    }

    static Pregunta getPregunta(int id) {
        return vectorPreguntas.get(id);
    }

    static int size() {
        return vectorPreguntas.size();
    }

}