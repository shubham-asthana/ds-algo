package com.programming.companies.nightfall.practice.ratelimiting.service;

public interface RateLimiter {

    boolean allowRequest(String userId);
}
