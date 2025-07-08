package com.programming.dsalgo.map;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class LRUCacheUsingLinkedHashMapThreadSafe {

    private final Map<Integer, Integer> map;

    private final ReentrantLock lock = new ReentrantLock();

    public LRUCacheUsingLinkedHashMapThreadSafe(int capacity) {
        this.map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true) {
            @Override
            public boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        lock.lock();
        try {
            return map.getOrDefault(key, -1);
        } finally {
            lock.unlock();
        }
    }

    public void put(int key, int value) {
        lock.lock();
        try {
            map.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        lock.lock();
        try {
            return map.size();
        } finally {
            lock.unlock();
        }
    }
}
