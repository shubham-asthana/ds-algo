package com.programming.companies.nightfall.practice.sessionmanagement.service.impl;

import java.lang.reflect.Field;
import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang3.StringUtils;

import com.programming.companies.nightfall.practice.sessionmanagement.dto.SessionInfo;
import com.programming.companies.nightfall.practice.sessionmanagement.exception.SessionExpiredException;
import com.programming.companies.nightfall.practice.sessionmanagement.exception.SessionNotFoundException;
import com.programming.companies.nightfall.practice.sessionmanagement.service.SessionService;

public class SessionServiceImpl implements SessionService {

    private final Map<String, SessionInfo> sessions = new HashMap<>();
    private final Duration sessionTimeout = Duration.ofSeconds(10);

    @Override
    public synchronized String createSession(long userId) {
        String token = UUID.randomUUID().toString();
        Instant now = Instant.now();
        sessions.put(token, new SessionInfo(userId, now));
        return token;
    }

    @Override
    public synchronized boolean isValid(String token) {
        SessionInfo sessionInfo = sessions.get(token);
        if (null == sessionInfo) {
            return false;
        }
        if (isExpired(sessionInfo.getCreationTime())) {
            return false;
        }

        return true;
    }

    @Override
    public synchronized long getUserId(String token) {
        if (StringUtils.isBlank(token)) {
            throw new IllegalArgumentException("Invalid token");
        }
        SessionInfo sessionInfo = sessions.get(token);
        if (null == sessionInfo) {
            throw new SessionNotFoundException(token);
        }
        if (isExpired(sessionInfo.getCreationTime())) {
            sessions.remove(token);
            throw new SessionExpiredException(token);
        }

        return sessionInfo.getUserId();
    }

    @Override
    public synchronized void invalidate(String token) {
        if (StringUtils.isBlank(token)) {
            throw new IllegalArgumentException("Invalid token");
        }
        SessionInfo sessionInfo = sessions.get(token);
        if (null == sessionInfo) {
            throw new SessionNotFoundException(token);
        }
        if (isExpired(sessionInfo.getCreationTime())) {
            sessions.remove(token);
            throw new SessionExpiredException(token);
        }

        SessionServiceImpl quick = new SessionServiceImpl() {
            {
                // Reflection to change private sessionTimeout to 1 second
                try {
                    Field f = SessionServiceImpl.class.getDeclaredField("sessionTimeout");
                    f.setAccessible(true);
                    f.set(this, Duration.ofSeconds(1));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };

        sessions.remove(token);
    }

    @Override
    public synchronized void cleanupExpiredSessions() {
        for (Map.Entry<String, SessionInfo> sessionEntry : sessions.entrySet()) {
            if (isExpired(sessionEntry.getValue().getCreationTime())) {
                sessions.remove(sessionEntry.getKey());
            }
        }
    }

    private boolean isExpired(Instant creationTime) {
        return Instant.now().isAfter(creationTime.plus(sessionTimeout));
    }
}
