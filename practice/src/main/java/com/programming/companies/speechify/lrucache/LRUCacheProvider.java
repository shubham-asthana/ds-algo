package com.programming.companies.speechify.lrucache;

public class LRUCacheProvider {

    public static <K, V> LRUCache<K, V> createLRUCache(CacheLimit cacheLimit) {
        return new LRUCacheImpl<>(cacheLimit.getMaxItems());
    }
}
