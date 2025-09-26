package com.programming.dsalgo.patterns.linkedlist;

import java.util.*;

public class MRUCacheWithTTL<K, V> {

    class Node {
        K key;
        V value;
        long expireAt; // expiry timestamp in ms
        Node prev, next;

        public Node(K key, V value, long ttlMillis) {
            this.key = key;
            this.value = value;
            this.expireAt = ttlMillis > 0 ? System.currentTimeMillis() + ttlMillis : Long.MAX_VALUE;
        }

        public boolean isExpired() {
            return System.currentTimeMillis() > expireAt;
        }
    }

    private final int capacity;
    private final Map<K, Node> cache;
    private final Node head, tail;

    public MRUCacheWithTTL(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(null, null, 0);
        this.tail = new Node(null, null, 0);
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        Node node = cache.get(key);

        if (node.isExpired()) {
            remove(node);
            cache.remove(key);
            return null;
        }

        moveToHead(node); // mark as most recently used
        return node.value;
    }

    public void put(K key, V value, long ttlMillis) {
        if (capacity == 0)
            return;

        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            node.expireAt = ttlMillis > 0 ? System.currentTimeMillis() + ttlMillis : Long.MAX_VALUE;
            moveToHead(node);
        } else {
            if (cache.size() == capacity) {
                // Evict most recently used = the node right after head
                Node toRemove = head.next;
                remove(toRemove);
                cache.remove(toRemove.key);
            }
            Node newNode = new Node(key, value, ttlMillis);
            insertToHead(newNode);
            cache.put(key, newNode);
        }
    }

    private void moveToHead(Node node) {
        remove(node);
        insertToHead(node);
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insertToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
}
