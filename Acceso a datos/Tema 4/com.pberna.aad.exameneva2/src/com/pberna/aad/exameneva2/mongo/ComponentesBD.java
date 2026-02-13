package com.pberna.aad.exameneva2.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import java.util.Scanner;

import static com.mongodb.client.model.Filters.eq;

public class ComponentesBD {

	private static final String CONNECTION_STRING = "mongodb://root:toty@localhost:27017/";
    private static final String DATABASE_NAME = "componentes";

    private static MongoClient mongoClient;
    private static MongoDatabase db;

	public void crearColeccionesConDatos() {
        try {
            MongoDatabase database = getDb();

            MongoCollection<Document> procesadoresColl = database.getCollection("procesadores");

            procesadoresColl.insertOne(new Document("modelo", "Intel Core i9-9900K")
			.append("nucleos", 8).append("hilos", 16).append("velocidad", "3.6 GHz"));
            procesadoresColl.insertOne(new Document("modelo", "AMD Ryzen 9 5900X")
                .append("nucleos", 12).append("hilos", 24).append("velocidad", "3.7 GHz"));

            MongoCollection<Document> discoCol = database.getCollection("discos_duros");
            discoCol.insertOne(new Document("modelo", "Samsung 970 EVO Plus")
                    .append("capacidadGb", 1000).append("interfaz", "NVMe PCIe 3.0 x4"));
            discoCol.insertOne(new Document("modelo", "Seagate Barracuda")
                    .append("capacidadGb", 2000).append("interfaz", "SATA 6Gb/s"));

            System.out.println("Colecciones creadas e insertadas con éxito.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
	
	public void asignarCampoPrecioProcesadores() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Introduce el modelo del procesador: ");
            String modelo = sc.nextLine();
            System.out.print("Introduce el precio: ");
            double precio = sc.nextDouble();

            MongoDatabase database = getDb();
            MongoCollection<Document> procCol = database.getCollection("procesadores");

            procCol.updateMany(eq("modelo", modelo), Updates.set("precio", precio));
            System.out.println("Precios actualizados para el modelo: " + modelo);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	public void borrarDiscoDuro() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Introduce el modelo de disco duro a borrar: ");
            String modelo = sc.nextLine();

            MongoDatabase database = getDb();
            MongoCollection<Document> discCol = database.getCollection("discos_duros");

            discCol.deleteOne(eq("modelo", modelo));
            System.out.println("Eliminado correctamente.");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

	public static void closeConnection() {
		if (mongoClient != null) {
            mongoClient.close();
            mongoClient = null;
        }
    }

    public static MongoDatabase getDb() {
        if (db == null) {
            mongoClient = MongoClients.create(CONNECTION_STRING);
            db = mongoClient.getDatabase(DATABASE_NAME);
        }
        return db;
    }
}
