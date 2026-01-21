package com.pberna.aad.ut4.classic;

import org.bson.BsonArray;
import org.bson.BsonValue;
import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.InsertOneResult;


public class EmpresaBD {
    private static final String NOMBRE_BASE_DATOS = "Empresa";
    private static final String CONNECTION_STRING= "mongodb://localhost:27017/";
    
    MongoClient clienteMongo;
    MongoDatabase baseDatos;

    public EmpresaBD() {        
        clienteMongo = MongoClients.create(CONNECTION_STRING);
        baseDatos = clienteMongo.getDatabase(NOMBRE_BASE_DATOS);
    }
    
    public void insertarEmpleado() {
        MongoCollection<Document> empleados = baseDatos.getCollection("Empleados");
        Document empleado = new Document();
        //empleado.append("_id", 7007);
        empleado.append("nombre", "Carmelo Guirao Costa");
        empleado.append("puesto", "Sistemas");
        empleado.append("departamento", 20);
        
        Document categoria = new Document();
        categoria.append("nombre", "Administrador");
        categoria.append("nivel", 10);
        //empleado.append("categoria", categoria);
        
        BsonArray categoriaArray = new BsonArray();        
        categoriaArray.add(categoria.toBsonDocument());        
        empleado.append("categoria", categoriaArray);
                
        empleados.insertOne(empleado);        
    }

    public void informacionColeccion(String coleccion) {
        MongoCollection<Document> collection = baseDatos.getCollection(coleccion);
        System.out.println("El número de documentos en la colección '"+collection.getNamespace()+"' es "+collection.countDocuments());
    }

    public void datosColeccion(String coleccion) {
        MongoCollection<Document> collection = baseDatos.getCollection(coleccion);        
        for (Document document : collection.find()) {
            System.out.println(document.toJson());
        }
    }//datosColeccion

    public void datosColeccionFiltrada(String coleccion, String consulta) {
        BasicDBObject parseDBObject = BasicDBObject.parse(consulta);
        MongoCollection<Document> collection = baseDatos.getCollection(coleccion);
        for (Document document : collection.find(parseDBObject)) {
            System.out.println(document.toJson());
        }
    }//datosColeccion

    public void agregaCampoEmpleado() {
        MongoCollection<Document> empleados = baseDatos.getCollection("Empleados");
        empleados.updateMany(new BasicDBObject(), Updates.set("salario",2000));
    }   

    public void borrarEmpleado() {
        MongoCollection<Document> empleados = baseDatos.getCollection("Empleados");
        empleados.deleteOne(Filters.eq("_id", 7007)); 
    }
    
    public void buscarEmpleadoPorId() {
    	System.out.println(baseDatos.getCollection("Empleados").find(
    			Filters.eq("_id", new ObjectId("696f5ca12e28fc07f8198be2")))
    			.first().toJson());
    }

    public void cerrarConexion() {
        clienteMongo.close();
    }

}
