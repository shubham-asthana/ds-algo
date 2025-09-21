package com.programming.systemdesign.lowleveldesign.ratelimiting;

import java.util.concurrent.atomic.AtomicInteger;

public class FixedWindow {

    private final int maxRequests;

    private final long windowSize;

    private long windowStart;

    private final AtomicInteger requestCount;

    public FixedWindow(int maxRequests, long windowSize) {
        this.maxRequests = maxRequests;
        this.windowSize = windowSize;
        this.windowStart = System.currentTimeMillis();
        this.requestCount = new AtomicInteger(0);
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();
        if (now - windowStart >= windowSize) {
            windowStart = now;
            requestCount.set(0);
        }
        return requestCount.incrementAndGet() <= maxRequests;
    }

    public static void main(String[] args) {
        FixedWindow fixedWindow = new FixedWindow(5, 1000);
        for (int i = 1; i <= 20; i++) {
            boolean allowed = fixedWindow.allowRequest();
            System.out.println("Request " + i + " Allowed: " + allowed);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
