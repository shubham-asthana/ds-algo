package com.programming.companies.nightfall.practice;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.programming.companies.nightfall.practice.sessionmanagement.exception.SessionExpiredException;
import com.programming.companies.nightfall.practice.sessionmanagement.exception.SessionNotFoundException;
import com.programming.companies.nightfall.practice.sessionmanagement.service.SessionService;
import com.programming.companies.nightfall.practice.sessionmanagement.service.impl.SessionServiceImpl;

public class SessionServiceTest {

    private SessionService sessionService;

    @BeforeEach
    void setup() {
        sessionService = new SessionServiceImpl();
    }

    @Test
    void testCreateSession() {
        String token = sessionService.createSession(1);
        assertNotNull(token);
        assertTrue(sessionService.isValid(token));
    }

    @Test
    void testIsValid() {
        String token = sessionService.createSession(1);
        assertTrue(sessionService.isValid(token));
        assertFalse(sessionService.isValid("random-string"));
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertFalse(sessionService.isValid(token));
    }

    @Test
    void testGetUserId() {
        assertThrows(IllegalArgumentException.class, () -> sessionService.getUserId(""));
        assertThrows(SessionNotFoundException.class, () -> sessionService.getUserId("random-string"));
        String token = sessionService.createSession(1);
        assertEquals(1, sessionService.getUserId(token));
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThrows(SessionExpiredException.class, () -> sessionService.getUserId(token));
    }

    @Test
    void testInvalidateSession() {
        assertThrows(IllegalArgumentException.class, () -> sessionService.invalidate(""));
        assertThrows(SessionNotFoundException.class, () -> sessionService.invalidate("random-string"));
        String token1 = sessionService.createSession(2);
        assertTrue(sessionService.isValid(token1));
        sessionService.invalidate(token1);
        assertFalse(sessionService.isValid(token1));
        String token = sessionService.createSession(2);
        assertTrue(sessionService.isValid(token));
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThrows(SessionExpiredException.class, () -> sessionService.invalidate(token));
    }

    @Test
    void testCleanupExpiredSessions() {
        String token1 = sessionService.createSession(1);
        try {
            Thread.sleep(12000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sessionService.cleanupExpiredSessions();
        assertThrows(SessionNotFoundException.class, () -> sessionService.getUserId(token1));
    }
}
