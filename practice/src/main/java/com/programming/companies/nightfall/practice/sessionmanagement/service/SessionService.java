package com.programming.companies.nightfall.practice.sessionmanagement.service;

public interface SessionService {
    /**
     * Create a new session for the given userId. Return the session token.
     */
    String createSession(long userId);

    /**
     * Return true if the session exists and is not expired; else false.
     * If token is null/blank, throw IllegalArgumentException.
     */
    boolean isValid(String token);

    /**
     * Return the userId for a valid session. If token not found: throw
     * SessionNotFoundException.
     * If token expired: throw SessionExpiredException.
     * If token null/blank: IllegalArgumentException.
     */
    long getUserId(String token);

    /**
     * Invalidate (remove) the session. If token not found:
     * SessionNotFoundException.
     * If expired: SessionExpiredException.
     */
    void invalidate(String token);

    /**
     * Purge all expired sessions from the in-memory store.
     */
    void cleanupExpiredSessions();
}
