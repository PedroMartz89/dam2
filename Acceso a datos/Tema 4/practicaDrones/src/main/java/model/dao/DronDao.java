package model.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import enumerates.EstadoDron;
import model.Dron;
import model.Mision;
import org.bson.Document;
import utils.DBConection;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;

public class DronDao implements dao<Dron> {
    private final String COLLECTION_NAME = "drons";

    private Document misionToDocument(Mision m) {
        return new Document("tipoMision", m.getTipoMision())
                .append("zona", m.getZona())
                .append("duracion", m.getDuracion())
                .append("exito", m.isExito())
                .append("nivelRiesgo", m.getNivelRiesgo());
    }

    @Override
    public void create(Dron entity) {
        MongoCollection<Document> collection = DBConection.getDb().getCollection(COLLECTION_NAME);
        Document dron = new Document("id_unico", entity.getId())
                .append("modelo", entity.getModelo())
                .append("anio_fabricacion", entity.getAnoFabricacion())
                .append("estado", entity.getEstado().name())
                .append("bateria", entity.getNivelBateria())
                .append("misiones", new ArrayList<Document>());
        collection.insertOne(dron);
    }

    @Override
    public Dron read(int id) {
        Document d = DBConection.getDb().getCollection(COLLECTION_NAME).find(eq("id_unico", id)).first();
        if (d == null) return null;

        Dron dron = new Dron();
        dron.setId(d.getInteger("id_unico"));
        dron.setModelo(d.getString("modelo"));
        dron.setAnoFabricacion(d.getString("anio_fabricacion"));
        dron.setNivelBateria(d.getInteger("bateria"));
        dron.setEstado(EstadoDron.valueOf(d.getString("estado")));

        List<Mision> misiones = new ArrayList<>();
        List<Document> docs = d.getList("misiones", Document.class);
        if (docs != null) {
            for (Document mDoc : docs) {
                Mision m = new Mision();
                m.setTipoMision(mDoc.getString("tipoMision"));
                m.setZona(mDoc.getString("zona"));
                m.setDuracion(mDoc.getLong("duracion"));
                m.setExito(mDoc.getBoolean("exito"));
                m.setNivelRiesgo(mDoc.getInteger("nivelRiesgo"));
                misiones.add(m);
            }
        }
        dron.setMisionesRealizadas(misiones);
        return dron;
    }

    @Override
    public void update(Dron entity) {
        DBConection.getDb().getCollection(COLLECTION_NAME).updateOne(
                eq("id_unico", entity.getId()),
                Updates.combine(
                        Updates.set("estado", entity.getEstado().name()),
                        Updates.set("bateria", entity.getNivelBateria())
                )
        );
    }

    @Override
    public void delete(Dron entity) {
        DBConection.getDb().getCollection(COLLECTION_NAME).deleteOne(eq("id_unico", entity.getId()));
    }

    @Override
    public List<Dron> findAll() {
        List<Dron> lista = new ArrayList<>();
        for (Document d : DBConection.getDb().getCollection(COLLECTION_NAME).find()) {
            lista.add(read(d.getInteger("id_unico")));
        }
        return lista;
    }

    public void registrarMision(int idDron, Mision mision) {
        DBConection.getDb().getCollection(COLLECTION_NAME).updateOne(
                eq("id_unico", idDron),
                Updates.push("misiones", misionToDocument(mision))
        );
    }

    public List<Dron> findBateriaBaja(int limite) {
        List<Dron> resultado = new ArrayList<>();
        for (Document d : DBConection.getDb().getCollection(COLLECTION_NAME).find(Filters.lt("bateria", limite))) {
            Dron dron = new Dron();
            dron.setModelo(d.getString("modelo"));
            dron.setNivelBateria(d.getInteger("bateria"));
            resultado.add(dron);
        }
        return resultado;
    }

    public List<Dron> findMisionesAltoRiesgo() {
        List<Dron> resultado = new ArrayList<>();
        for (Document d : DBConection.getDb().getCollection(COLLECTION_NAME).find(Filters.gte("misiones.nivelRiesgo", 4))) {
            resultado.add(read(d.getInteger("id_unico")));
        }
        return resultado;
    }
}