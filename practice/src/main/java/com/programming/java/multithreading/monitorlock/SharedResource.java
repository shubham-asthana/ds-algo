package com.programming.java.multithreading.monitorlock;

public class SharedResource {

    boolean isItemPresent = false;

    public synchronized void produceItem() {
        isItemPresent = true;
        System.out.println("Producer thread calling notify method");
        notifyAll();
    }

    public synchronized void consumeItem() {
        System.out.println("Consumer thread inside consume item method");
        // if (!isItemPresent) {
        // using while loop to avoid spurious wake-up beacuse of system noise
        while (!isItemPresent) {
            try {
                System.out.println("Consumer thread is waiting");
                wait(); // release monitor locks
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Consumer thread consumed the item");
        isItemPresent = false;
    }
}
