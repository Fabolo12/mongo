package com.popov.repository;

import com.mongodb.client.MongoDatabase;
import com.popov.model.Person;

import java.util.Set;

public class PersonRepository extends AbstractRepository<Person> {
    private static final String COLLECTION_NAME = "persons";

    private static PersonRepository instance;

    public static PersonRepository getInstance(final MongoDatabase db) {
        if (instance == null) {
            instance = new PersonRepository(db);
        }

        return instance;
    }

    private PersonRepository(final MongoDatabase db) {
        super(db, COLLECTION_NAME);
    }


    public Set<Person> findAll() {
        return super.findAll(Person.class);
    }
}
