package com.programming.java.multithreading.locks.stamped.optimisticlock;

public class OptimisticExample {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();
        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 0 calling produce method");
            sharedResource.produce();
        });

        Thread thread2 = new Thread(() -> {
            System.out.println("Thread 1 calling consume method");
            sharedResource.consume();
        });

        thread1.start();
        thread2.start(); // -> No write lock => t1 validate of stmp successful when t2
        // not there
    }
}
