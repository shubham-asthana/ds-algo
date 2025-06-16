package com.programming.java.multithreading.producerconsumer;

import java.util.ArrayDeque;
import java.util.Deque;

public class SharedResource {

    Deque<Integer> buffer = new ArrayDeque<>();
    int capacity = 3;

    public synchronized void produceData(int data) {
        // System.out.println("Producer thread inside produce data method");
        while (buffer.size() == capacity) {
            try {
                System.out.println("Producer thread is waiting for consumer to consume the data from the buffer");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        buffer.offer(data);
        System.out.println("Data produced by the producer: " + buffer.peekLast());
        notify();
    }

    public synchronized int consumeData() {
        // System.out.println("Consumer thread inside consume data method");
        while (buffer.isEmpty()) {
            try {
                System.out.println("Consumer thread is waiting for producer to produce data and add it to the buffer");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int data = buffer.poll();
        System.out.println("Data consumed by the consumer: " + data);
        notify();
        return data;
    }
}
