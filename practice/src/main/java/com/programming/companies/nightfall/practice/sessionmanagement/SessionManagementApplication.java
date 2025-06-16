package com.programming.companies.nightfall.practice.sessionmanagement;

import com.programming.companies.nightfall.practice.sessionmanagement.exception.SessionExpiredException;
import com.programming.companies.nightfall.practice.sessionmanagement.exception.SessionNotFoundException;
import com.programming.companies.nightfall.practice.sessionmanagement.service.SessionService;
import com.programming.companies.nightfall.practice.sessionmanagement.service.impl.SessionServiceImpl;

public class SessionManagementApplication {

    public static void main(String[] args) {
        SessionService service = new SessionServiceImpl();

        System.out.println("Creating session for first user");
        String token = service.createSession(1);

        System.out.println("Checking if session is valid");
        System.out.println("Is Session Valid for User 1: " + service.isValid(token));
        System.out.println("Get User Id: " + service.getUserId(token));

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Checking if session is valid");
        System.out.println("Is Session Valid for User 1: " + service.isValid(token));

        try {
            System.out.println("Get User Id: " + service.getUserId(token));
        } catch (SessionExpiredException e) {
            System.out.println("Attempted to get user for an expired session: " + e);
        }

        try {
            service.invalidate(token);
        } catch (SessionNotFoundException e) {
            System.out.println("Attempted to get user for an expired session: " + e);
        }

        try {
            System.out.println("Get User Id: " + service.getUserId(token));
        } catch (SessionNotFoundException e) {
            System.out.println("Attempted to get user for a non-existing session: " + e);
        }
    }
}
