package com.programming.companies.nightfall.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.programming.companies.nightfall.sessionmanagement.service.UserSessionService;
import com.programming.companies.nightfall.sessionmanagement.service.impl.UserSessionServiceImpl;

public class UserSessionServiceTest {

    private UserSessionService userSessionService;

    @BeforeEach
    void setup() {
        userSessionService = new UserSessionServiceImpl();
    }

    @Test
    void testCreateSessionIsActiveSession() {
        String sessionId = userSessionService.createSession("user1");
        assertTrue(userSessionService.isSessionActive(sessionId));
    }

    @Test
    void testRenewSession() throws InterruptedException {
        String sessionId = userSessionService.createSession("user2");
        assertTrue(userSessionService.isSessionActive(sessionId));

        Thread.sleep(10);
        assertTrue(userSessionService.renewSession(sessionId));
        assertTrue(userSessionService.isSessionActive(sessionId));
    }

    @Test
    void testInvalidateSession() {
        String sessionId = userSessionService.createSession("user3");
        assertTrue(userSessionService.invalidateSession(sessionId));
        assertFalse(userSessionService.isSessionActive(sessionId));
    }

    @Test
    void testGetUserSessions() {
        String sessionId1 = userSessionService.createSession("user4");
        String sessionId2 = userSessionService.createSession("user4");
        assertEquals(2, userSessionService.getUserSessions("user4").size());
    }

    @Test
    void testExpiredSessionIsRemoved() {

    }
}
