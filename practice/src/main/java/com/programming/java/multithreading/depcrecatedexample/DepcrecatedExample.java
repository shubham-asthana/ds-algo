package com.programming.java.multithreading.depcrecatedexample;

public class DepcrecatedExample {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        System.out.println("Main thread started");

        Thread thread1 = new Thread(() -> {
            System.out.println("Thread 1 calling produce method");
            sharedResource.produce();

        });

        Thread thread2 = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread 2 calling produce method");
            sharedResource.produce();
        });

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread 1 is suspended");
        thread1.suspend();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread 1 is resumed");
        thread1.resume();

        System.out.println("Main thread is finished");
    }
}
