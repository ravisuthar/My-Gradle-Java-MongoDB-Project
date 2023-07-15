package com.example;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Mongo {

    private static final String uri = "mongodb://localhost:27017";

    public MongoCollection<Document> getMongoCollection() {
        MongoClientURI mongoClientURI = new MongoClientURI(uri);
        MongoClient mongoClient = new MongoClient(mongoClientURI);

        MongoDatabase mongoDatabase = mongoClient.getDatabase("latest_db");
        MongoCollection<Document> studentCollection = mongoDatabase.getCollection("students");
        return studentCollection;
    }
}
