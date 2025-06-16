package com.programming.java.multithreading.monitorlock;

public class MonitorLocksExample {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Thread producerThread = new Thread(() -> {
            // System.out.println("Producer Thread: " + Thread.currentThread().getName());
            try {
                Thread.sleep(2000); // ensures consumer thread is started first
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            sharedResource.produceItem();
        });

        Thread consumerThread = new Thread(() -> {
            // System.out.println("Consumer Thread: " + Thread.currentThread().getName());
            sharedResource.consumeItem();
        });

        producerThread.start();
        consumerThread.start();
    }
}
