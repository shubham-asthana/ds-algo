package com.programming.companies.nightfall.practice.ratelimiting.service.impl;

import java.time.Clock;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.programming.companies.nightfall.practice.ratelimiting.service.RateLimiter;

public class SlidingWindowRateLimiter implements RateLimiter {

    private final int maxRequests;
    private final long windowSize;
    private final Clock clock;

    private final Map<String, Deque<Long>> userRequests = new HashMap<>();

    public SlidingWindowRateLimiter(int maxRequests, long windowSize, Clock clock) {
        this.maxRequests = maxRequests;
        this.windowSize = windowSize;
        this.clock = clock;
    }

    @Override
    public synchronized boolean allowRequest(String userId) {
        if (StringUtils.isBlank(userId))
            throw new IllegalArgumentException("User is blank or null");
        long now = clock.millis();
        Deque<Long> timeStamps = userRequests.computeIfAbsent(userId, k -> new LinkedList<>());

        while (!timeStamps.isEmpty() && timeStamps.peekFirst() <= now - windowSize)
            timeStamps.removeFirst();

        if (timeStamps.size() < maxRequests) {
            timeStamps.addLast(now);
            return true;
        }

        return false;
    }
}
