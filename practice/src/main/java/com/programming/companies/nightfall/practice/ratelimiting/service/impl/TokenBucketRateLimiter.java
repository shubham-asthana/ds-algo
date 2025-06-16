package com.programming.companies.nightfall.practice.ratelimiting.service.impl;

import com.programming.companies.nightfall.practice.ratelimiting.service.RateLimiter;

public class TokenBucketRateLimiter implements RateLimiter {

    @Override
    public boolean allowRequest(String userId) {

        return false;
    }
}
