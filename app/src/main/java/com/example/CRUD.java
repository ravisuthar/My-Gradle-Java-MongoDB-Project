package com.example;

import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Updates.combine;
import static com.mongodb.client.model.Updates.set;

public class CRUD extends Mongo {

    public void create() {
        Document document = new Document()
                .append("name", "Ravi")
                .append("age", "22");
        getMongoCollection().insertOne(document);
        System.out.println("Document created!");
    }

    public void read() {
        Document document = getMongoCollection().find().first();
        System.out.println("Student: " + document.toJson());
    }

    public void update() {
        UpdateResult updateResult = getMongoCollection().updateOne(
                eq("name", "Ravi Prasad Suthar"),
                combine(set("age", "23"))
        );
        long modifiedCount = updateResult.getModifiedCount();
        System.out.println("Document updated successful!, modifiedCount: " + modifiedCount);
    }

    public void delete() {
        DeleteResult age = getMongoCollection().deleteMany(eq("age", "22"));
        long deletedCount = age.getDeletedCount();
        System.out.println("Document deleted successful!, deletedCount: " + deletedCount);
    }

}