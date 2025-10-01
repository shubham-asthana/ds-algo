package com.programming.dsalgo.patterns.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {

    class Node {
        K key;
        V value;
        Node prev, next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;

    private final Map<K, Node> cache;

    private final Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(null, null);
        this.tail = new Node(null, null);
        head.next = tail;
        tail.prev = head;
    }

    public V get(K key) {
        if (!cache.containsKey(key)) {
            return null;
        }
        Node node = cache.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(K key, V value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            if (cache.size() == this.capacity) {
                Node toRemove = tail.prev;
                remove(toRemove);
                cache.remove(toRemove.key);
            }
            Node newNode = new Node(key, value);
            insertToHead(newNode);
            cache.put(key, newNode);
        }
    }

    public boolean isEmpty() {
        return cache.isEmpty();
    }

    // Return evicted key (used by LFU)
    public K evictOne() {
        if (cache.isEmpty())
            return null;
        Node toRemove = tail.prev;
        remove(toRemove);
        cache.remove(toRemove.key);
        return toRemove.key;
    }

    // Allow LFU to explicitly remove key
    public void remove(K key) {
        Node node = cache.get(key);
        if (node != null) {
            remove(node);
            cache.remove(key);
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

    public String toString() {
        Map<K, V> map = new HashMap<>();
        for (Map.Entry<K, Node> entry : cache.entrySet()) {
            map.put(entry.getKey(), entry.getValue().value);
        }
        return map.toString();
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(3);
        cache.put(1, "1");
        cache.put(2, "2");
        cache.put(3, "3");
        System.out.println(cache);

        cache.get(1);
        cache.put(4, "4");
        System.out.println(cache);
    }
}
