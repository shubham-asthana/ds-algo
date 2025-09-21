package com.programming.systemdesign.lowleveldesign.ratelimiting;

public class SlidingWindowCounter {

    private final int maxRequests;

    private final long windowSize;

    private long currentWindowStart;

    private long currentWindowCount;

    private long lastWindowCount;

    public SlidingWindowCounter(int maxRequests, long windowSize) {
        this.maxRequests = maxRequests;
        this.windowSize = windowSize;
        this.currentWindowStart = System.currentTimeMillis();
        this.currentWindowCount = 0;
        this.lastWindowCount = 0;
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();
        long elapsed = now - currentWindowStart;

        if (elapsed >= windowSize) {
            lastWindowCount = currentWindowCount;
            currentWindowCount = 0;
            currentWindowStart = now;
            elapsed = 0;
        }

        double weightedCount = lastWindowCount * ((windowSize - elapsed) / windowSize) + currentWindowCount;
        if (weightedCount < maxRequests) {
            currentWindowCount++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        SlidingWindowCounter slidingWindowCounter = new SlidingWindowCounter(5, 1000);
        for (int i = 1; i <= 20; i++) {
            boolean allowed = slidingWindowCounter.allowRequest();
            System.out.println("Request " + i + " Allowed: " + allowed);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
