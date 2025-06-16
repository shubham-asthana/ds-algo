package com.programming.java.multithreading.locks.semaphore;

import java.util.concurrent.Semaphore;

public class SharedResource {

    boolean isAvailable;
    Semaphore lock = new Semaphore(2);

    public void produce() {
        try {
            lock.acquire();
            System.out.println("Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.release();
            System.out.println("Lock released by: " + Thread.currentThread().getName());
        }
    }
}
