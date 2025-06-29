package com.programming.systemdesign.highleveldesign.ratelimiting;

import java.time.Instant;

public class SlidingWindowCounter {

    private final long windowSize;

    private final long maxRequestsPerWindow;

    private long currentWindowStart;

    private long currentWindowCount;

    private long previousWindowCount;

    public SlidingWindowCounter(final long windowSize, final long maxRequestsPerWindow) {
        this.windowSize = windowSize;
        this.maxRequestsPerWindow = maxRequestsPerWindow;
        this.currentWindowStart = Instant.now().getEpochSecond();
        this.currentWindowCount = 0;
        this.previousWindowCount = 0;
    }

    public synchronized boolean allowRequest() {
        final long now = Instant.now().getEpochSecond();
        long timePassedInCurrentWindow = now - currentWindowStart;

        if (timePassedInCurrentWindow >= windowSize) {
            previousWindowCount = currentWindowCount;
            currentWindowCount = 0;
            currentWindowStart = now;
            timePassedInCurrentWindow = 0;
        }

        final double weightedCount = previousWindowCount * ((windowSize - timePassedInCurrentWindow) / windowSize)
                + currentWindowCount;

        if (weightedCount < maxRequestsPerWindow) {
            currentWindowCount++;
            return true;
        }
        return false;
    }
}
