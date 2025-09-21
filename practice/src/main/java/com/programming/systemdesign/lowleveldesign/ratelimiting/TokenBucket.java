package com.programming.systemdesign.lowleveldesign.ratelimiting;

public class TokenBucket {

    private final int capacity;

    private final double refillRate;

    private double availableTokens;

    private long lastRefillTime;

    public TokenBucket(int capacity, double refillRate) {
        this.capacity = capacity;
        this.refillRate = refillRate / 1000.0;
        this.availableTokens = capacity;
        this.lastRefillTime = System.currentTimeMillis();
    }

    public synchronized boolean allowRequest() {
        long now = System.currentTimeMillis();

        double newTokens = (now - lastRefillTime) * refillRate;
        availableTokens = Math.min(availableTokens + newTokens, capacity);
        lastRefillTime = now;

        if (availableTokens >= 1) {
            availableTokens--;
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TokenBucket tokenBucket = new TokenBucket(5, 2);
        for (int i = 1; i <= 20; i++) {
            boolean allowed = tokenBucket.allowRequest();
            System.out.println("Request " + i + " Allowed: " + allowed);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
