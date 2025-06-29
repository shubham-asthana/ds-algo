package com.programming.systemdesign.highleveldesign.ratelimiting;

import java.time.Instant;
import java.util.LinkedList;
import java.util.Queue;

public class SlidingWindowLog {

    private final long windowSize;

    private final long maxRequestsPerWindow;

    private final Queue<Long> requestTimestampLog;

    public SlidingWindowLog(final long windowSize, final long maxRequestsPerWindow) {
        this.windowSize = windowSize;
        this.maxRequestsPerWindow = maxRequestsPerWindow;
        requestTimestampLog = new LinkedList<>();
    }

    public synchronized boolean allowRequest() {
        final long now = Instant.now().getEpochSecond();
        final long windowStart = now - windowSize;

        while (!requestTimestampLog.isEmpty() && requestTimestampLog.peek() <= windowStart) {
            requestTimestampLog.poll();
        }
        if (requestTimestampLog.size() < maxRequestsPerWindow) {
            requestTimestampLog.offer(now);
            return true;
        }
        return false;
    }
}
