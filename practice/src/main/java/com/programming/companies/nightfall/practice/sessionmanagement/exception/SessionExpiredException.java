package com.programming.companies.nightfall.practice.sessionmanagement.exception;

public class SessionExpiredException extends RuntimeException {

    public SessionExpiredException(String token) {
        super("Session expired for token: " + token);
    }
}
