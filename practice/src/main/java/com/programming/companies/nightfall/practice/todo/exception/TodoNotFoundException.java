package com.programming.companies.nightfall.practice.todo.exception;

public class TodoNotFoundException extends RuntimeException {

    public TodoNotFoundException(long id) {
        super("Todo with id: " + id + " not found");
    }
}
