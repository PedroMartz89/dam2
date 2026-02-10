package com.pberna.aad.exameneva2.mongo;

import java.util.List;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Updates;

public class ComponentesBD {

	private static final String NOMBRE_BASE_DATOS = "componentes";
	private static final String CONNECTION_STRING = "mongodb://localhost:27017/";

	MongoClient clienteMongo;
	MongoDatabase baseDatos;

	public ComponentesBD() {
		clienteMongo = MongoClients.create(CONNECTION_STRING);
		baseDatos = clienteMongo.getDatabase(NOMBRE_BASE_DATOS);
	}

	public void crearColeccionesConDatos() {

		// Procesadores
		MongoCollection<Document> procesadores = baseDatos.getCollection("procesadores");

		Document procesador1 = new Document();
		procesador1.append("modelo", "Intel Core i9-9900K");
		procesador1.append("nucleos", 8);
		procesador1.append("hilos", 16);
		procesador1.append("velocidad", "3.6 GHZ");

		Document procesador2 = new Document();
		procesador2.append("modelo", "AMD Ryzen 9 5900X");
		procesador2.append("nucleos", 12);
		procesador2.append("hilos", 24);
		procesador2.append("velocidad", "3.7 GHZ");

		procesadores.insertOne(procesador1);
		procesadores.insertOne(procesador2);

		// discos duros
		MongoCollection<Document> discosDuros = baseDatos.getCollection("disco_duros");

		Document hdd1 = new Document();
		hdd1.append("modelo", "Samsung 970 EVO Plus");
		hdd1.append("capacidadGb", 1000);
		hdd1.append("interfaz", "NVMe PCIe 3.0 4X");		

		Document hdd2 = new Document();
		hdd2.append("modelo", "Seagate barracuda");
		hdd2.append("capacidadGb", 2000);
		hdd2.append("interfaz", "NATA 6Gb/s");	
				
		discosDuros.insertMany(List.of(new Document [] {hdd1, hdd2}));

	}

	public void asignarCampoPrecioProcesadores() {
		try(Scanner scanner  = new Scanner(System.in)) {
			System.out.println("Introduce un modelo de procesador");
			String modelo = scanner.nextLine();
			
			System.out.println("Introduce el precio");
			double precio = scanner.nextDouble();
			//scanner.nextLine();
			
			MongoCollection<Document> procesadores = baseDatos.getCollection("procesadores");
			
			procesadores.updateMany( 
					BasicDBObject.parse(
							"{\"modelo\": \"" + modelo + "\"}"), 
					Updates.set("precio", precio));
			
		}
	}

	public void borrarDiscoDuro() {
		try(Scanner scanner  = new Scanner(System.in)) {
			System.out.println("Introduce un modelo de disco duro");
			String modelo = scanner.nextLine();
			
			MongoCollection<Document> discosDuros = baseDatos.getCollection("disco_duros");
			
			discosDuros.deleteOne(BasicDBObject.parse(
					"{\"modelo\": \"" + modelo + "\"}"));
		}
	}
}
