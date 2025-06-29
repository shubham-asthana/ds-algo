package com.programming.systemdesign.highleveldesign.ratelimiting;

import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

public class LeakyBucket {

    private final long capacity;

    private final double leakRate;

    private final Queue<Instant> bucket;

    private Instant lastLeakTime;

    public LeakyBucket(final long capacity, final double leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate;
        this.bucket = new LinkedList<>();
        this.lastLeakTime = Instant.now();
    }

    public synchronized boolean allowRequest() {
        leak();
        if (bucket.size() < capacity) {
            bucket.offer(Instant.now());
            return true;
        }
        return false;
    }

    private void leak() {
        final Instant now = Instant.now();
        final int leakedRequests = (int) ((now.toEpochMilli() - lastLeakTime.toEpochMilli()) * leakRate / 1000.0);

        for (int i = 0; i < leakedRequests; i++) {
            bucket.poll();
        }
        lastLeakTime = now;
    }
}
