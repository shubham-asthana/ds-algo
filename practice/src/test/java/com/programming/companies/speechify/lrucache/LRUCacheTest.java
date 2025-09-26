package com.programming.companies.speechify.lrucache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class LRUCacheTest {

    @Test
    public void shouldReturnValueForExistingKey() {
        LRUCache<String, String> lruCache = LRUCacheProvider.createLRUCache(new CacheLimit(10));
        lruCache.put("foo", "bar");
        assertEquals("bar", lruCache.get("foo"));
    }

    @Test
    public void shouldReturnNullForNonExistingKey() {
        LRUCache<String, String> lruCache = LRUCacheProvider.createLRUCache(new CacheLimit(10));
        lruCache.put("foo", "bar");
        assertNull(lruCache.get("bar"));
        assertNull(lruCache.get(""));
    }

    @Test
    public void shouldReturnValueForManyExistingKeys() {
        LRUCache<String, String> lruCache = LRUCacheProvider.createLRUCache(new CacheLimit(10));
        lruCache.put("foo", "bar");
        lruCache.put("baz", "baz");
        assertEquals("bar", lruCache.get("foo"));
        assertEquals("baz", lruCache.get("baz"));
    }

    @Test
    public void shouldReturnNullForLRUKey() {
        LRUCache<String, String> lruCache = LRUCacheProvider.createLRUCache(new CacheLimit(1));
        lruCache.put("foo", "bar");
        lruCache.put("baz", "baz");
        assertNull(lruCache.get("foo"));
        assertEquals("baz", lruCache.get("baz"));
    }

    @Test
    public void shouldReturnValueForRecreatedKey() {
        LRUCache<String, String> lruCache = LRUCacheProvider.createLRUCache(new CacheLimit(1));
        lruCache.put("foo", "bar");
        lruCache.put("baz", "baz");
        lruCache.put("foo", "bar");
        assertEquals("bar", lruCache.get("foo"));
        assertNull(lruCache.get("baz"));
    }

    @Test
    public void shouldRemoveOldKeys() {
        LRUCache<String, String> lruCache = LRUCacheProvider.createLRUCache(new CacheLimit(3));
        lruCache.put("bax", "par");
        lruCache.put("foo", "bar1");
        lruCache.put("foo", "bar2");
        lruCache.put("baz", "baz1");
        lruCache.put("foo", "bar3");
        lruCache.put("baz", "baz2");
        assertEquals("bar3", lruCache.get("foo"));
        assertEquals("baz2", lruCache.get("baz"));
        assertEquals("par", lruCache.get("bax"));
    }

    @Test
    public void itemIsConsideredAccessedWhenGetIsCalled() {
        LRUCache<String, String> lruCache = LRUCacheProvider.createLRUCache(new CacheLimit(2));
        lruCache.put("1key", "1value");
        lruCache.put("2key", "2value");
        lruCache.get("1key");
        lruCache.put("3key", "3value");
        assertEquals("1value", lruCache.get("1key"));
    }
}
