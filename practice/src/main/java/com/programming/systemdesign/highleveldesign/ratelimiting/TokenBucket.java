package com.programming.systemdesign.highleveldesign.ratelimiting;

import java.time.Instant;

public class TokenBucket {

    private final long capacity;

    private final double refillRate;

    private double tokens;

    private Instant lastRefillTime;

    public TokenBucket(final long capacity, final double refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate;
        this.tokens = capacity;
        this.lastRefillTime = Instant.now();
    }

    public synchronized boolean allowRequest(final int tokens) {
        refill();
        if (this.tokens < tokens) {
            return false;
        }
        this.tokens -= tokens;
        return true;
    }

    private void refill() {
        final Instant now = Instant.now();
        final double tokenToAdd = (now.toEpochMilli() - this.lastRefillTime.toEpochMilli()) * refillRate / 1000.0;
        this.tokens = Math.min(this.capacity, this.tokens + tokenToAdd);
        this.lastRefillTime = now;
    }
}
