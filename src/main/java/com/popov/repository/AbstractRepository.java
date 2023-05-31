package com.popov.repository;

import com.google.gson.Gson;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class AbstractRepository<T> {
    protected static final Gson GSON = new Gson();

    protected final MongoCollection<Document> collection;

    protected AbstractRepository(final MongoDatabase db, final String collectionName) {
        this.collection = db.getCollection(collectionName);
    }

    protected Document mapFrom(T item) {
        return Document.parse(GSON.toJson(item));
    }

    public void insertMany(Set<T> set) {
        final List<Document> collect = set.stream()
                .map(this::mapFrom)
                .collect(Collectors.toList());

        collection.insertMany(collect);
    }

    public Set<T> findAll(final Class<T> type) {
        return collection.find()
                .map(x -> GSON.fromJson(x.toJson(), type))
                .into(new HashSet<>());
    }
}
