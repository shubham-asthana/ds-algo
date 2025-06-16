package com.programming.companies.nightfall.sessionmanagement.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

import com.programming.companies.nightfall.sessionmanagement.service.UserSessionService;

public class UserSessionServiceImpl implements UserSessionService {

    private static final long EXPIRY_IN_MS = 15 * 60 * 1000;

    private static class Session {
        String userId;
        long expiryTime;

        Session(String userId, long expiryTime) {
            this.userId = userId;
            this.expiryTime = expiryTime;
        }
    }

    private final Map<String, Session> sessions = new ConcurrentHashMap<>();
    private final Map<String, Set<String>> userSessions = new ConcurrentHashMap<>();

    @Override
    public String createSession(String userId) {
        String sessionId = UUID.randomUUID().toString();
        long expiryTime = System.currentTimeMillis() + EXPIRY_IN_MS;
        Session session = new Session(userId, expiryTime);
        sessions.put(sessionId, session);

        Set<String> sessionSet = userSessions.get(userId);
        if (null == sessionSet) {
            sessionSet = ConcurrentHashMap.newKeySet();
            Set<String> existingSet = userSessions.putIfAbsent(userId, sessionSet);
            if (null != existingSet) {
                sessionSet = existingSet;
            }
        }
        sessionSet.add(sessionId);
        return sessionId;
    }

    @Override
    public boolean isSessionActive(String sessionId) {
        Session session = sessions.get(sessionId);
        if (null == session)
            return false;
        if (session.expiryTime < System.currentTimeMillis()) {
            invalidateSession(sessionId);
            return false;
        }
        return true;
    }

    @Override
    public boolean renewSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (null == session)
            return false;
        if (session.expiryTime < System.currentTimeMillis()) {
            invalidateSession(sessionId);
            return false;
        }
        session.expiryTime = System.currentTimeMillis() + EXPIRY_IN_MS;
        return true;
    }

    @Override
    public boolean invalidateSession(String sessionId) {
        Session session = sessions.get(sessionId);
        if (null == session)
            return false;

        Set<String> userSessionIds = userSessions.get(session.userId);
        if (null == userSessionIds)
            return false;
        return userSessionIds.remove(sessionId);
    }

    @Override
    public List<String> getUserSessions(String userId) {
        Set<String> userSessionIds = userSessions.get(userId);
        return userSessionIds.stream()
                .filter(this::isSessionActive)
                .collect(Collectors.toList());
    }
}
