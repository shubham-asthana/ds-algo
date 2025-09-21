package com.programming.dsalgo.patterns.linkedlist;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache_UsingLinkedHashMap<K, V> {

    private final int capacity;
    private final Map<K, V> cache;

    public LRUCache_UsingLinkedHashMap(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<K, V>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
                return size() > LRUCache_UsingLinkedHashMap.this.capacity;
            }
        };
    }

    public V get(K key) {
        return cache.getOrDefault(key, null);
    }

    public void put(K key, V value) {
        cache.put(key, value);
    }

    @Override
    public String toString() {
        return cache.toString();
    }

    public static void main(String[] args) {
        LRUCache_UsingLinkedHashMap<Integer, String> cache = new LRUCache_UsingLinkedHashMap<>(3);
        cache.put(1, "1");
        cache.put(2, "2");
        cache.put(3, "3");
        System.out.println(cache);

        cache.get(1);
        cache.put(4, "4");
        System.out.println(cache);
    }
}
