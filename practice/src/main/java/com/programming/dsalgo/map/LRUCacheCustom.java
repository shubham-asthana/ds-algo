package com.programming.dsalgo.map;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;

public class LRUCacheCustom {

    class Node {
        int key, value;
        Node prev, next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Node head, tail;
    private final Map<Integer, Node> map;
    private final ReentrantLock lock = new ReentrantLock();

    public LRUCacheCustom(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        lock.lock();
        try {
            if (!map.containsKey(key))
                return -1;
            Node node = map.get(key);
            moveToHead(node);
            return node.value;
        } finally {
            lock.unlock();
        }
    }

    public void put(int key, int value) {
        lock.lock();
        try {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                node.value = value;
                moveToHead(node);
            } else {
                if (map.size() == capacity) {
                    Node toRemove = tail.prev;
                    remove(toRemove);
                    map.remove(toRemove.key);
                }
                Node newNode = new Node(key, value);
                insertToHead(newNode);
                map.put(key, newNode);
            }
        } finally {
            lock.unlock();
        }
    }

    private void insertToHead(Node newNode) {
        newNode.next = head.next;
        newNode.prev = head;
        head.next.prev = newNode;
        head.next = newNode;
    }

    private void remove(Node toRemove) {
        toRemove.prev.next = toRemove.next;
        toRemove.next.prev = toRemove.prev;
    }

    private void moveToHead(Node node) {
        remove(node);
        insertToHead(node);
    }
}
