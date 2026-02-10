package com.pberna.aad.exameneva2.mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.List;

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
		MongoCollection<Document> procesadores = baseDatos.getCollection("procesadores");
		Document doc1 = new Document();
		doc1.append("modelo", "Intel Core i0-9900K");
		doc1.append("nucleos", 8);
		doc1.append("hilos", 16);
		doc1.append("velocidad", "3.6 GHZ");

		Document procesador2 = new Document();
		procesador2.append("modelo", "AMD Ryzen 9 5900X");
		procesador2.append("nucleos", 12);
		procesador2.append("hilos", 24);
		procesador2.append("velocidad", "3.7 GHZ");

		procesadores.insertOne(doc1);
		procesadores.insertOne(procesador2);

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
		
	}
	
	public void borrarDiscoDuro() {
		
	}
}
