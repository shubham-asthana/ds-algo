package com.programming.dsalgo.map;

import java.util.HashMap;
import java.util.Map;

public class LFUCache {

    class Node {
        int key, value;
        Node prev, next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    Map<Integer, Node> cache;
    int capacity;
    Node head, tail;

    public LFUCache(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key))
            return -1;
        Node node = cache.get(key);

        return node.value;
    }

    public void put(int key, int value) {

    }
}
