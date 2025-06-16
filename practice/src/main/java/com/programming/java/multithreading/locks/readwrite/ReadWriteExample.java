package com.programming.java.multithreading.locks.readwrite;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteExample {

    public static void main(String[] args) {

        SharedResource sharedResource1 = new SharedResource();

        ReadWriteLock lock = new ReentrantReadWriteLock();

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 0 calling produce method");
            sharedResource1.produce(lock); // Shared lock
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 1 calling produce method");
            sharedResource1.produce(lock); // shared lock
        });

        SharedResource sharedResource2 = new SharedResource();
        Thread thread3 = new Thread(() -> {
            System.out.println("Thread 2 calling consume method");
            sharedResource2.consume(lock); // exclusive lock
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
