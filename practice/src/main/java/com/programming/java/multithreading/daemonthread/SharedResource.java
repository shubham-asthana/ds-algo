package com.programming.java.multithreading.daemonthread;

public class SharedResource {

    boolean isAvailable;

    public synchronized void produce() {
        System.out.println("Lock acquired");
        isAvailable = true;
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Lock released");
    }
}
