package com.programming.companies.speechify.lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheImpl<K, V> implements LRUCache<K, V> {

    int capacity;

    Map<K, V> cache;

    public LRUCacheImpl(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> entry) {
                return size() > capacity;
            }
        };
    }

    @Override
    public V get(K key) {
        return cache.getOrDefault(key, null);
    }

    @Override
    public void put(K key, V value) {
        cache.put(key, value);
    }
}
