package com.programming.companies.nightfall.practice.ratelimiting.service.impl;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.programming.companies.nightfall.practice.ratelimiting.service.RateLimiter;

public class FixedWindowRateLimiter implements RateLimiter {

    private final int maxRequests;
    private final long windowSize;

    private final Map<String, UserCounter> counters = new ConcurrentHashMap<>();

    private static class UserCounter {
        long windowStart;
        int count;

        UserCounter(long windowStart, int count) {
            this.windowStart = windowStart;
            this.count = count;
        }
    }

    private FixedWindowRateLimiter(int maxRequests, long windowSize) {
        this.maxRequests = maxRequests;
        this.windowSize = windowSize;
    }

    @Override
    public boolean allowRequest(String userId) {
        long now = System.currentTimeMillis();
        long currentWindow = now - (now % windowSize);

        UserCounter userCounter = counters.compute(userId, (key, existing) -> {
            if (existing == null) {
                return new UserCounter(currentWindow, 1);
            } else {
                if (existing.windowStart == maxRequests) {
                    if (existing.count < maxRequests) {
                        existing.count++;
                        return existing;
                    } else {
                        return existing;
                    }
                }
                return new UserCounter(currentWindow, 1);
            }
        });
        return userCounter.count <= maxRequests && userCounter.windowStart == currentWindow;
    }
}
