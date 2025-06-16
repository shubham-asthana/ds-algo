package com.programming.companies.nightfall.sessionmanagement.service;

import java.util.List;

public interface UserSessionService {

    // creates a session with 15 min expiry, returns sessionId
    String createSession(String userId);

    // checks if session exists and not expired
    boolean isSessionActive(String sessionId);

    // resets expiry to 15 min from now, returns false if session invalid
    boolean renewSession(String sessionId);

    // deletes session, returns true if existed
    boolean invalidateSession(String sessionId);

    // lists all active sessionIds for a user
    List<String> getUserSessions(String userId);
}
