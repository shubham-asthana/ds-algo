package com.programming.java.multithreading.daemonthread;

public class DaemonThreadExample {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        System.out.println("Main thread started");

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 calling produce method");
            sharedResource.produce();
        });

        thread1.setDaemon(true); // thread will not be able to wait for 8sec for the lock to get released as main
                                 // is finished
        thread1.start();

        System.out.println("Main thread is finished");
    }
}
