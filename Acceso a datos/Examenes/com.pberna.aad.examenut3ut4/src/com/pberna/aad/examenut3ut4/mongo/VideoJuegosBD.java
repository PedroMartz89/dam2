package com.pberna.aad.examenut3ut4.mongo;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.List;
import java.util.Scanner;

public class VideoJuegosBD {
    private static final String NOMBRE_BASE_DATOS = "examen";
    private static final String CONNECTION_STRING = "mongodb://localhost:27017/";

    MongoClient clienteMongo;
    MongoDatabase baseDatos;

    public VideoJuegosBD() {
        clienteMongo = MongoClients.create(CONNECTION_STRING);
        baseDatos = clienteMongo.getDatabase(NOMBRE_BASE_DATOS);
    }

	public void crearColeccionConDatos() {

        MongoCollection<Document> videojuegos = baseDatos.getCollection("videojuegos");

        Document doc1 = new Document();
        doc1.append("titulo", "The Legend of Zelda Breath of the Wild");
        String[] plataformas = new String[2];
        plataformas[0] = "Nintendo Switch";
        plataformas[1] = "Wii U";

        doc1.append("plataformas", plataformas);
        doc1.append("detalles", new Document()
                .append("genero", "aventura")
                .append("desarrolador", "Nintendo")
                .append("anioLanzamiento", 2017));

        Document doc2 = new Document();
        doc1.append("titulo", "Elden Ring");
        String[] plataformas2 = new String[3];
        plataformas2[0] = "PC";
        plataformas2[1] = "Play Station 5";
        plataformas2[2] = "Xbox Series X";
        doc2.append("plataformas", plataformas2);

        doc2.append("detalles", new Document()
                .append("genero", "RPG")
                .append("desarrolador", "FromSoftware")
                .append("anioLanzamiento", 2022));

        Document doc3 = new Document();
        doc1.append("titulo", "Cyberpunk 2077");
        doc2.append("plataformas", plataformas2);

        doc2.append("detalles", new Document()
                .append("genero", "RPG")
                .append("desarrolador", "CD Project Red")
                .append("anioLanzamiento", 2020));

        videojuegos.insertMany(List.of(new Document [] {doc1, doc2, doc3}));

    }
	
	public void asignarCampoPrecio() {
        try(Scanner scanner  = new Scanner(System.in)) {
            System.out.println("Introduce el título del videojuego");
            String titulo = scanner.nextLine();

            System.out.println("Introduce el precio");
            double precio = scanner.nextDouble();

            MongoCollection<Document> videojuegos = baseDatos.getCollection("videojuegos");

            videojuegos.updateOne(
                    BasicDBObject.parse(
                            "{\"titulo\": \"" + titulo + "\"}"),
                    Updates.set("precio", precio));

        }
	}
	
	public void borrarJuegosDesarrollador() {
        try(Scanner scanner  = new Scanner(System.in)) {
            System.out.println("Introduce el nombre del desarrollador: ");
            String desarrollador = scanner.nextLine();

            MongoCollection<Document> videojuegos = baseDatos.getCollection("videojuegos");

            videojuegos.deleteMany(Filters.eq("desarrolador",desarrollador));

        }
	}
}
