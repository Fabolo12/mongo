package com.popov.utils;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoUtil {
    private static MongoClient mongoClient;

    private MongoUtil() {
    }

    public static MongoDatabase connect(final String databaseName) {
        if (mongoClient == null) {
            mongoClient = new MongoClient("localhost", 27017);
        }
        return mongoClient.getDatabase(databaseName);
    }
}
