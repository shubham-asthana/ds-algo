package com.programming.systemdesign.highleveldesign.ratelimiting;

import java.time.Instant;

public class FixedWindow {

    private final long windowSize;

    private final long maxRequestsPerWindow;

    private long currentWindowStart;

    private long requestCount;

    public FixedWindow(final long windowSize, final long maxRequestsPerWindow) {
        this.windowSize = windowSize;
        this.maxRequestsPerWindow = maxRequestsPerWindow;
        this.currentWindowStart = Instant.now().getEpochSecond();
        this.requestCount = 0;
    }

    public synchronized boolean allowRequest() {
        final long now = Instant.now().getEpochSecond();

        if (now - currentWindowStart >= windowSize) {
            currentWindowStart = now;
            requestCount = 0;
        }

        if (requestCount < maxRequestsPerWindow) {
            requestCount++;
            return true;
        }
        return false;
    }
}
