package utils;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class DBConection {
    private static final String CONNECTION_STRING = "mongodb://localhost:27017/";
    private static final String DATABASE_NAME = "drones";

    private static MongoClient mongoClient;
    private static MongoDatabase db;

    private DBConection() {

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
