package com.popov.action;

import lombok.Getter;

@Getter
public enum Action {
    CREATE_PERSON("Create person", new CreatePerson()),
    PRINT_PERSONS("Print all persons", new ShowPersons()),
    EXIT("Exit", new Exit());

    private final String name;

    private final ActionType actionType;

    Action(final String name, final ActionType actionType) {
        this.name = name;
        this.actionType = actionType;
    }

    @Override
    public String toString() {
        return name;
    }
}
