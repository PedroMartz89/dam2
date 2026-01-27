package model.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import enumerates.EstadoDron;
import model.Dron;
import model.Mision;
import org.bson.Document;
import utils.DBConection;

import javax.print.Doc;
import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class DronDao implements dao<Dron> {
    @Override
    public void create(Dron entity) {
        try {

            MongoCollection<Document> drones = DBConection.getDb().getCollection("drones");
            Document dron = new Document();
            dron.append("id_unico", entity.getId());
            dron.append("anio_fabricacion", entity.getAnoFabricacion());
            dron.append("estado", entity.getEstado());
            dron.append("modelo", entity.getModelo());
            dron.append("bateria", entity.getNivelBateria());
            dron.append("misiones", entity.getMisionesRealizadas());

            drones.insertOne(dron);
        } catch (Exception e) {
            System.out.printf("No se ha insertado");
        }
    }

    @Override
    public Dron read(int id) {
        MongoDatabase db = DBConection.getDb();
        MongoCollection<Document> drones = db.getCollection("drones");
        Document d = drones.find(eq("id_unico", id)).first();
        Dron dron = new Dron();
        assert d != null;

        List<Document> misionesDoc = d.getList("misiones", Document.class);
        List<Mision> misiones = new ArrayList<>();
        for (Document doc : misionesDoc) {
            Mision m = new Mision();
            m.setTipoMision(doc.getString("tipoMision"));
            m.setZona(doc.getString("zona"));
            m.setDuracion(doc.getLong("diracion"));
            m.setExito(doc.getBoolean("exito"));
            m.setNivelRiesgo(doc.getInteger("nivelRiesgo"));
            misiones.add(m);
        }

        dron.setId(d.getInteger("id_unico"));
        dron.setAnoFabricacion((d.getString("anio_fabricacion")));
        dron.setEstado(EstadoDron.valueOf(d.getString("estado")));
        dron.setModelo(d.getString("modelo"));
        dron.setNivelBateria(d.getInteger("bateria"));
        dron.setMisionesRealizadas(misiones);
        return dron;

    }

    @Override
    public void update(Dron entity) {
        MongoDatabase db = DBConection.getDb();
        MongoCollection<Document> drones = db.getCollection("drones");

        Document doc = new Document();
        doc.append("id_unico", entity.getId());
        doc.append("anio_fabricacion", entity.getAnoFabricacion());
        doc.append("estado", entity.getEstado());
        doc.append("modelo", entity.getModelo());
        doc.append("bateria", entity.getNivelBateria());
        doc.append("misiones", entity.getMisionesRealizadas());

        drones.replaceOne(eq("id_unico", entity.getId()), doc);
    }

    @Override
    public void delete(Dron entity) {
        MongoDatabase db = DBConection.getDb();
        MongoCollection<Document> drones = db.getCollection("drones");

        drones.deleteOne(eq("id_unico", entity.getId()));
    }

    @Override
    public List<Dron> findAll() {
        MongoDatabase db = DBConection.getDb();
        MongoCollection<Document> dronesDoc = db.getCollection("drones");
        List<Dron> drones = new ArrayList<>();
        List<Mision> misiones = new ArrayList<>();

        for (Document d : dronesDoc.find()) {

            Mision m = new Mision();
            m.setTipoMision(d.getString("tipoMision"));
            m.setZona(d.getString("zona"));
            m.setDuracion(d.getLong("diracion"));
            m.setExito(d.getBoolean("exito"));
            m.setNivelRiesgo(d.getInteger("nivelRiesgo"));
            misiones.add(m);
            Dron dron = new Dron();
            dron.setId(d.getInteger("id_unico"));
            dron.setAnoFabricacion((d.getString("anio_fabricacion")));
            dron.setEstado(EstadoDron.valueOf(d.getString("estado")));
            dron.setModelo(d.getString("modelo"));
            dron.setNivelBateria(d.getInteger("bateria"));
            dron.setMisionesRealizadas(misiones);
            drones.add(dron);
        }

        return drones;
    }
}
