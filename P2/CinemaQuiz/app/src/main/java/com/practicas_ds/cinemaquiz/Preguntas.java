package com.practicas_ds.cinemaquiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Preguntas {
    protected static List<Pregunta> vectorPreguntas = ejemploPreguntas();

    public Preguntas() {
        vectorPreguntas = ejemploPreguntas();
    }

    static void shuffle() { Collections.shuffle(vectorPreguntas); }

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
        //NUEVAS
        preguntas.add(new Pregunta(
                "¿Cuál de los siguientes no es un enanito en la película Blancanieves y los siete enanitos?",
                "Cascarrabias",
                "Timido",
                "Mocoso",
                "Dormilón",
                0,null
        ));
        preguntas.add(new Pregunta(
                "¿Qué es Stitch de la película Lilo y Stitch? ",
                "Un alienígena",
                "Un koala",
                "Un mono",
                "Una niña",
                0,null
        ));
        preguntas.add(new Pregunta(
                "¿Cuál de los siguientes titanes no aparece en la película Hércules?",
                "Titán de agua",
                "Titán de roca",
                "Titán de lava",
                "Titán de hielo",
                0,null
        ));
        preguntas.add(new Pregunta(
                "¿Cuántos niños consiguen un billete dorado para la fábrica de Willy Wonka en Charlie y la fábrica de chocolate?",
                "5",
                "6",
                "7",
                "4",
                0,null
        ));
        preguntas.add(new Pregunta(
                "¿Cómo se denominan a los seres humanos que no tienen poderes mágicos en el mundo de Harry Potter?",
                "Muggle",
                "Tuffel",
                "Monnel",
                "Riddle",
                0,null
        ));
        preguntas.add(new Pregunta(
                "¿En qué año se estrenó Pinocho?",
                "1940",
                "1970",
                "1960",
                "1980",
                0,null
        ));
        preguntas.add(new Pregunta(
                "¿Cuántas hadas madrinas aparecen en la película Cenicienta?",
                "1",
                "2",
                "3",
                "4",
                0,null
        ));
        preguntas.add(new Pregunta(
                "¿En qué se convierte la carroza de Cenicienta pasada la media noche?",
                "Una calabaza",
                "Un melón",
                "Una mandarina",
                "Una berenjena",
                0,null
        ));
        preguntas.add(new Pregunta(
                "¿Qué actriz interpreta el papel de bruja en la película Maléfica?",
                "Angelina Jolie",
                "Elle fanning",
                "Julia Roberts",
                "Sandra Bullock",
                0,null
        ));
        preguntas.add(new Pregunta(
                "¿Con qué alimento mantiene relaciones sexuales Jim en la película American Pie?",
                "Una tarta",
                "Un filete",
                "Un melón",
                "Un donut",
                0,null
        ));
        preguntas.add(new Pregunta(
                "¿En qué grupo político quiere meterse Brian en La vida de Brian?",
                "Frente Popular de Judea",
                "Frente Judaico Popular",
                "Frente del pueblo Judaico",
                "Unión Popular",
                0,null
        ));
        preguntas.add(new Pregunta(
                "¿Cómo se llama el perro de Asterix y Obelix?",
                "Ideafix",
                "Matusalix",
                "Panoramix",
                "Milú",
                0,null
        ));
        preguntas.add(new Pregunta(
                "¿Qué insecto protagoniza la película Bichos?",
                "Una hormiga",
                "Una oruga",
                "Un saltamontes",
                "Un insecto palo",
                0,null
        ));
        preguntas.add(new Pregunta(
                "¿En qué país está ambientada la película Ciudad de Dios?",
                "Brasil",
                "Méjico",
                "Argentina",
                "Filipinas",
                0,null
        ));
        preguntas.add(new Pregunta(
                "¿Cómo se llama el cangrejo de La Sirenita?",
                "Sebastián",
                "Arturo",
                "Lobster",
                "Roberto",
                0,null
        ));

        return preguntas;
    }
}