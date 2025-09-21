package com.programming.systemdesign.lowleveldesign.ratelimiting;

public class LeakyBucket {

    private final int capacity;

    private final double leakRate;

    private double currentRequests;

    private long lastUpdateTime;

    public LeakyBucket(int capacity, double leakRate) {
        this.capacity = capacity;
        this.leakRate = leakRate / 1000.0;
        this.currentRequests = 0;
        this.lastUpdateTime = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();
        long elapsed = now - lastUpdateTime;
        currentRequests = Math.max(0, currentRequests - elapsed * leakRate);
        if (currentRequests < capacity) {
            currentRequests++;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LeakyBucket leakyBucket = new LeakyBucket(5, 5);
        for (int i = 1; i <= 20; i++) {
            boolean allowed = leakyBucket.allowRequest();
            System.out.println("Request " + i + " Allowed: " + allowed);
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
