package com.programming.dsalgo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.programming.dsalgo.map.LRUCacheCustom;

public class LRUCacheCustomTest {

    @Test
    void testGetAndPut() {
        LRUCacheCustom cache = new LRUCacheCustom(2);
        cache.put(1, 10);
        cache.put(2, 20);
        assertEquals(10, cache.get(1));
        assertEquals(20, cache.get(2));
    }

    @Test
    void testEviction() {
        LRUCacheCustom cache = new LRUCacheCustom(2);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.get(1);
        cache.put(3, 30);
        assertEquals(-1, cache.get(2));
    }

    @Test
    void testUpdate() {
        LRUCacheCustom cache = new LRUCacheCustom(2);
        cache.put(1, 10);
        cache.put(1, 20);
        assertEquals(20, cache.get(1));
    }

    @Test
    void testConcurrentAccessSimulation() {
        LRUCacheCustom cache = new LRUCacheCustom(3);
        Runnable writer = () -> {
            for (int i = 0; i < 10; i++) {
                cache.put(i, i * 10);
            }
        };
        Runnable reader = () -> {
            for (int i = 0; i < 10; i++) {
                cache.get(i);
            }
        };
        Thread t1 = new Thread(writer);
        Thread t2 = new Thread(reader);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            fail("Threads interrupted");
        }
    }
}
