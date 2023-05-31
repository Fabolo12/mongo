package com.popov.service;

import com.popov.model.Person;
import com.popov.repository.PersonRepository;

import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class PersonService {
    private static final Random RANDOM = new Random();

    private static PersonService instance;

    private final PersonRepository personRepository;

    private PersonService(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public static PersonService getInstance(final PersonRepository personRepository) {
        if (instance == null) {
            instance = new PersonService(personRepository);
        }

        return instance;
    }

    public String create() {
        final Person person = createPerson();
        personRepository.insertMany(Set.of(person));
        return person.getId();
    }

    private Person createPerson() {
        final Person person = new Person();
        person.setId(UUID.randomUUID().toString());
        person.setName("Name" + RANDOM.nextInt());
        person.setAge(80);
        return person;
    }

    public Set<Person> getAll() {
        return personRepository.findAll();
    }
}
