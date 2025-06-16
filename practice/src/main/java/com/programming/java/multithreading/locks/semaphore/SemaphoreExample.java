package com.programming.java.multithreading.locks.semaphore;

public class SemaphoreExample {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 calling produce method");
            sharedResource.produce();
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 2 calling produce method");
            sharedResource.produce();
        });

        Thread thread3 = new Thread(() -> {
            System.out.println("Thread 3 calling produce method");
            sharedResource.produce();
        });

        Thread thread4 = new Thread(() -> {
            System.out.println("Thread 4 calling produce method");
            sharedResource.produce();
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
