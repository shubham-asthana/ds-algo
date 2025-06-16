package com.programming.java.multithreading.threadjoining;

public class ThreadJoiningExample {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        System.out.println("Main thread started");

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 calling produce method");
            sharedResource.produce();
        });

        thread1.start();

        try {
            System.out.println("Main thread waiting for thread 1 to finish");
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread is finished");
    }
}
