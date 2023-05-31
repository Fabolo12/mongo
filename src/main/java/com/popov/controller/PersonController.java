package com.popov.controller;

import com.popov.service.PersonService;

public class PersonController {
    private PersonService personService;

    private static PersonController instance;

    public static PersonController getInstance(final PersonService personService) {
        if (instance == null) {
            instance = new PersonController(personService);
        }

        return instance;
    }

    private PersonController(final PersonService personService) {
        this.personService = personService;
    }

    public void create() {
        System.out.println(personService.create());
    }

    public void showAll() {
        personService.getAll().forEach(System.out::println);
    }
}
