package com.programming.dsalgo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import com.programming.dsalgo.map.LRUCacheUsingLinkedHashMapThreadSafe;

public class LRUCacheLinkedHashMapTest {

    @Test
    void testGetAndPut() {
        LRUCacheUsingLinkedHashMapThreadSafe cache = new LRUCacheUsingLinkedHashMapThreadSafe(2);
        cache.put(1, 10);
        cache.put(2, 20);
        assertEquals(10, cache.get(1));
        assertEquals(20, cache.get(2));
    }

    @Test
    void testEviction() {
        LRUCacheUsingLinkedHashMapThreadSafe cache = new LRUCacheUsingLinkedHashMapThreadSafe(2);
        cache.put(1, 10);
        cache.put(2, 20);
        cache.get(1);
        cache.put(3, 30);
        assertEquals(-1, cache.get(2));
    }

    @Test
    void testUpdate() {
        LRUCacheUsingLinkedHashMapThreadSafe cache = new LRUCacheUsingLinkedHashMapThreadSafe(2);
        cache.put(1, 10);
        cache.put(1, 20);
        assertEquals(20, cache.get(1));
    }
}
