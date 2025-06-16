package com.programming.java.multithreading.locks.renentrant;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    boolean isAvailable;

    public void produce(ReentrantLock lock) {
        try {
            lock.lock();
            System.out.println("Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            System.out.println("Lock released by: " + Thread.currentThread().getName());
        }
    }
}
