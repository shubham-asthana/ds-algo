package com.programming.java.multithreading.locks.renentrant;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {

    public static void main(String[] args) {

        SharedResource sharedResource1 = new SharedResource();

        ReentrantLock lock = new ReentrantLock();

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 calling produce method");
            sharedResource1.produce(lock);
        });

        SharedResource sharedResource2 = new SharedResource();
        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 calling produce method");
            sharedResource2.produce(lock);
        });

        thread1.start();
        thread2.start();
    }
}
