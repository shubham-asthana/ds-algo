package com.programming.companies.nightfall.practice.sessionmanagement.exception;

public class SessionNotFoundException extends RuntimeException {

    public SessionNotFoundException(String token) {
        super("Session not found for token: " + token);
    }
}
