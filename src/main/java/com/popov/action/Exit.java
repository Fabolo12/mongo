package com.popov.action;

public class Exit implements ActionType {
    @Override
    public void doAction() {
        System.exit(0);
    }
}
