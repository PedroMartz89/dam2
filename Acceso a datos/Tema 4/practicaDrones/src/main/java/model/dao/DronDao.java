package model.dao;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import model.Dron;
import org.bson.Document;
import utils.DBConection;

import java.util.List;

public class DronDao implements dao<Dron> {
    @Override
    public void create(Dron entity) {

    }

    @Override
    public Dron read(int id) {
        MongoDatabase db = DBConection.getDb();
        MongoCollection<Document> drones = db.getCollection("drons");
        Document dron = new Document();


    }

    @Override
    public void update(Dron entity) {

    }

    @Override
    public void delete(Dron entity) {

    }

    @Override
    public List<Dron> findAll() {
        return List.of();
    }
}
