package com.programming.java.multithreading.locks.condition;

public class ConditionExample {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                sharedResource.produce();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 2; i++) {
                sharedResource.consume();
            }
        });

        thread1.start();
        thread2.start();
    }
}
