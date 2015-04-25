package com.practicas_ds.cinemaquiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Preguntas {
    protected static List<Pregunta> vectorPreguntas = ejemploPreguntas();

    public Preguntas() {
        vectorPreguntas = ejemploPreguntas();
    }

    static void shuffle() { vectorPreguntas = ejemploPreguntas(); }

    static Pregunta getPregunta(int id) {
        return vectorPreguntas.get(id);
    }

    static void addPregunta(Pregunta pregunta) {
        vectorPreguntas.add(pregunta);
    }

    static void removePregunta(int id) {
        vectorPreguntas.remove(id);
    }

    public static int size() {
        return vectorPreguntas.size();
    }

    public static ArrayList<Pregunta> ejemploPreguntas() {
        ArrayList<Pregunta> preguntas = new ArrayList<Pregunta>();

        preguntas.add(new Pregunta(
                "¿Cuál de estos nombres corresponde al agujero negro de la imagen?",
                "Gargantúa",
                "Gargántula",
                "Garganta",
                "Gargantilla",
                1, "gargantua"));
        preguntas.add(new Pregunta(
                "¿En qué película podemos ver esta nave espacial?",
                "Star Wars",
                "Star Trek",
                "Interstellar",
                "2001: Una odisea del espacio",
                1, "destructor_imperial"));
        preguntas.add(new Pregunta(
                "¿Quién interpretó a Mike Shiner en Birdman?",
                "Edward Norton",
                "Michael Keaton",
                "Leonardo DiCaprio",
                "Brad Pitt",
                0, null));
        preguntas.add(new Pregunta(
                "¿Quién dirigió El club de la lucha?",
                "David Fincher",
                "Edward Norton",
                "Christopher Nolan",
                "Frank Darabont",
                0, null));
        preguntas.add(new Pregunta(
                "¿Cómo se llama esta bebida que podemos ver en La naranja mecánica?",
                "Leche plus",
                "Cóctel Miloko",
                "Cóctel Molokov",
                "Piña colada",
                1, "leche_plus"));
        preguntas.add(new Pregunta(
                "¿La aparición de qué fruta suele preceder una muerte en El padrino?",
                "Naranja",
                "Limón",
                "Plátano",
                "Melocotón",
                0, null));
        preguntas.add(new Pregunta(
                "¿Quién dirigió Shutter Island?",
                "Martin Scorsese",
                "Stanley Kubrick",
                "Christopher Nolan",
                "Frank Darabont",
                0, null));
        preguntas.add(new Pregunta(
                "¿Qué físico aparece en El truco final?",
                "Nikola Tesla",
                "Albert Einstein",
                "Thomas Edison",
                "Stephen Hawking",
                0, null));
        preguntas.add(new Pregunta(
                "¿Qué deporte practican en Million Dollar Baby?",
                "Boxeo",
                "Lucha libre",
                "Taekwondo",
                "Karate",
                0, null));
        preguntas.add(new Pregunta(
                "¿En qué película podemos ver esta imagen?",
                "Forrest Gump",
                "La chaqueta metálica",
                "Apocalypse Now",
                "Salvar al soldado Ryan",
                1, "bubba"));
        preguntas.add(new Pregunta(
                "¿Qué película ganó el Goya a la mejor película en el año 2015?",
                "La isla mínima",
                "El niño",
                "Celda 211",
                "Lo imposible",
                0, null));
        preguntas.add(new Pregunta(
                "¿En cuál de estas películas no aparece David Bowie?",
                "Road Trip",
                "Dentro del laberinto",
                "El truco final",
                "Basquiat",
                0, null));
        preguntas.add(new Pregunta(
                "¿En qué película podemos escuchar este silbido?",
                "Kill Bill",
                "Reservoir Dogs",
                "Django desencadenado",
                "Malditos bastardos",
                2, "twisted_nerve"
        ));
        preguntas.add(new Pregunta(
                "¿En qué película escuchamos esta banda sonora?",
                "Parque jurásico",
                "Indiana Jones",
                "El señor de los anillos",
                "Star Wars",
                2, "parque_jurasico"
        ));
        preguntas.add(new Pregunta(
                "¿En qué película podemos escuchar esta canción?",
                "Reservoir Dogs",
                "Pulp Fiction",
                "Los hombres de negro",
                "Kill Bill",
                2, "little_green_bag"
        ));
        preguntas.add(new Pregunta(
                "¿Quién es el director de Primos?",
                "Daniel Sánchez Arévalo",
                "Alejandro Amenábar",
                "Alberto Rodríguez",
                "Daniel Monzón",
                0, null
        ));
        preguntas.add(new Pregunta(
                "¿Quién coprotagoniza con Luis Tosar La flaqueza del bolchevique?",
                "María Valverde",
                "Belén Rueda",
                "Inma Cuesta",
                "Clara Lago",
                0, null
        ));
        preguntas.add(new Pregunta(
                "¿Qué profesión ejerce el personaje que interpreta Ben Stiller en Más que amigos?",
                "Rabino",
                "Cura",
                "Panadero",
                "Repartidor de pizzas",
                0, null
        ));
        preguntas.add(new Pregunta(
                "¿En qué película nos encontramos con este personaje?",
                "El caballero oscuro",
                "Batman",
                "Batman & Robin",
                "El caballero oscuro: La leyenda renace",
                1, "joker"
        ));
        preguntas.add(new Pregunta(
                "¿Quién se acaba convirtiendo en periodista de guerra en La chaqueta metálica?",
                "Recluta bufón",
                "Recluta patoso",
                "Copo de nieve",
                "Recluta artista",
                0, null
        ));
        preguntas.add(new Pregunta(
                "¿Quién dirigió Oldboy?",
                "Park Chan-wook",
                "Cho Young-wuk",
                "Chun Chung-hoon",
                "Kim ki-duk",
                0, null
        ));
        preguntas.add(new Pregunta(
                "¿En qué película encontramos esta escena de Travolta bailando?",
                "Pulp Fiction",
                "Grease",
                "Fiebre del sábado noche",
                "Cerdos salvajes",
                1, "travolta_dancing"
        ));
        preguntas.add(new Pregunta(
                "¿A qué película corresponde esta imagen?",
                "Cadena perpetua",
                "Como dios",
                "Sigo como dios",
                "Invictus",
                1, "robbins_freeman"
        ));
        preguntas.add(new Pregunta(
                "¿En qué película podemos escuchar esta canción?",
                "La flaqueza del bolchevique",
                "Mar adentro",
                "Hablé con ella",
                "Los lunes al sol",
                2, "standby"
        ));
        preguntas.add(new Pregunta(
                "¿En qué película podemos escuchar esta banda sonora?",
                "Origen",
                "Interstellar",
                "Rush",
                "El caballero oscuro",
                2, "time"
        ));
        Collections.shuffle(preguntas);
        return preguntas;
    }
}