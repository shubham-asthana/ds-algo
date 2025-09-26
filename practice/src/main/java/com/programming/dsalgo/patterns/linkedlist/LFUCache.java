package com.programming.dsalgo.patterns.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LFUCache<K, V> {

    private final int capacity;
    private int minFreq;

    private final Map<K, Integer> keyFreqMap;

    private final Map<Integer, LRUCache<K, V>> freqCacheMap;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyFreqMap = new HashMap<>();
        this.freqCacheMap = new HashMap<>();
    }

    public V get(K key) {
        if (!keyFreqMap.containsKey(key)) {
            return null;
        }

        int freq = keyFreqMap.get(key);
        LRUCache<K, V> oldCache = freqCacheMap.get(freq);

        V value = oldCache.get(key);
        if (value == null)
            return null;

        // Move key to next frequency
        oldCache.remove(key);
        if (oldCache.isEmpty() && freq == minFreq) {
            minFreq++;
        }

        int newFreq = freq + 1;
        keyFreqMap.put(key, newFreq);
        freqCacheMap.computeIfAbsent(newFreq, f -> new LRUCache<>(capacity)).put(key, value);

        return value;
    }

    public void put(K key, V value) {
        if (capacity == 0)
            return;

        if (keyFreqMap.containsKey(key)) {
            // Update existing value and bump frequency
            get(key); // will move key to next frequency
            int freq = keyFreqMap.get(key);
            freqCacheMap.get(freq).put(key, value); // update value in new freq
            return;
        }

        if (keyFreqMap.size() >= capacity) {
            // Evict from minFreq bucket
            LRUCache<K, V> lru = freqCacheMap.get(minFreq);
            K evictKey = lru.evictOne();
            keyFreqMap.remove(evictKey);
        }

        // Add new key with frequency = 1
        keyFreqMap.put(key, 1);
        freqCacheMap.computeIfAbsent(1, f -> new LRUCache<>(capacity)).put(key, value);
        minFreq = 1;
    }
}
