package com.programming.companies.speechify.lrucache;

public class CacheLimit {

    private final int maxItems;

    public CacheLimit(int maxItems) {
        this.maxItems = maxItems;
    }

    public int getMaxItems() {
        return maxItems;
    }
}
