package com.popov.action;

import com.mongodb.client.MongoDatabase;
import com.popov.controller.PersonController;
import com.popov.repository.PersonRepository;
import com.popov.service.PersonService;
import com.popov.utils.MongoUtil;

public class ShowPersons implements ActionType {
    private final MongoDatabase database = MongoUtil.connect("aLevel6");

    private final PersonRepository personRepository = PersonRepository.getInstance(database);

    private final PersonService personService = PersonService.getInstance(personRepository);

    private final PersonController personController = PersonController.getInstance(personService);

    @Override
    public void doAction() {
        personController.showAll();
    }
}
