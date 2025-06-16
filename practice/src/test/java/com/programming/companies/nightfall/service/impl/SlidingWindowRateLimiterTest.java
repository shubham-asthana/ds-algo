package com.programming.companies.nightfall.service.impl;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

import org.junit.jupiter.api.Test;

import com.programming.companies.nightfall.practice.ratelimiting.service.RateLimiter;
import com.programming.companies.nightfall.practice.ratelimiting.service.impl.SlidingWindowRateLimiter;

public class SlidingWindowRateLimiterTest {

    private RateLimiter ratelimiter;

    static class MutableClock extends Clock {

        private long currentTimeInMs;

        MutableClock(long startMs) {
            this.currentTimeInMs = startMs;
        }

        void advanceBy(long ms) {
            currentTimeInMs += ms;
        }

        @Override
        public ZoneId getZone() {
            return ZoneId.systemDefault();
        }

        @Override
        public Clock withZone(ZoneId zone) {
            return this;
        }

        @Override
        public Instant instant() {
            return Instant.ofEpochMilli(currentTimeInMs);
        }
    }

    @Test
    void testAllowRequestsWithinLimit() {
        ratelimiter = new SlidingWindowRateLimiter(3, 1000, new MutableClock(0L));
        String user = "testUser";
        assertTrue(ratelimiter.allowRequest(user));
        assertTrue(ratelimiter.allowRequest(user));
        assertTrue(ratelimiter.allowRequest(user));
    }

    @Test
    void testAllowRequestsOutsideLimit() {
        ratelimiter = new SlidingWindowRateLimiter(2, 1000, new MutableClock(0L));
        String user = "testUser";
        assertTrue(ratelimiter.allowRequest(user));
        assertTrue(ratelimiter.allowRequest(user));
        assertFalse(ratelimiter.allowRequest(user));
    }

    @Test
    void testSlidingWindowExpiry() {
        MutableClock clock = new MutableClock(0L);
        ratelimiter = new SlidingWindowRateLimiter(2, 1000, clock);
        String user = "test";
        assertTrue(ratelimiter.allowRequest(user));

        clock.advanceBy(500);
        assertTrue(ratelimiter.allowRequest(user));
        assertFalse(ratelimiter.allowRequest(user));

        clock.advanceBy(501);
        assertTrue(ratelimiter.allowRequest(user));
    }

    @Test
    void testDifferentUsers() {
        ratelimiter = new SlidingWindowRateLimiter(1, 1000, new MutableClock(0L));
        String user1 = "testUser1";
        String user2 = "testUser2";
        assertTrue(ratelimiter.allowRequest(user1));
        assertFalse(ratelimiter.allowRequest(user1));

        assertTrue(ratelimiter.allowRequest(user2));
        assertFalse(ratelimiter.allowRequest(user2));
    }

    @Test
    void testNullUser() {
        ratelimiter = new SlidingWindowRateLimiter(1, 1000, new MutableClock(0L));
        assertThrows(IllegalArgumentException.class, () -> ratelimiter.allowRequest(null));
    }
}
