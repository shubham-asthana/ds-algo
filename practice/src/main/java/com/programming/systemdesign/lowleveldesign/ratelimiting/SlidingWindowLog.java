package com.programming.systemdesign.lowleveldesign.ratelimiting;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowLog {

    private final int maxRequests;

    private final long windowSize;

    private final Deque<Long> timestampLog;

    public SlidingWindowLog(int maxRequests, long windowSize) {
        this.maxRequests = maxRequests;
        this.windowSize = windowSize;
        this.timestampLog = new ArrayDeque<>();
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();
        while (!timestampLog.isEmpty() && timestampLog.peek() <= now - windowSize) {
            timestampLog.poll();
        }
        if (timestampLog.size() < maxRequests) {
            timestampLog.offerLast(now);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SlidingWindowLog slidingWindowLog = new SlidingWindowLog(5, 1000);
        for (int i = 1; i <= 20; i++) {
            boolean allowed = slidingWindowLog.allowRequest();
            System.out.println("Request " + i + " Allowed: " + allowed);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
