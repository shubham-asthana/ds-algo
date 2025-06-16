package com.programming.java.multithreading.locks.stamped.readwrite;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    boolean isAvailable;
    StampedLock stampedLock = new StampedLock();

    public void produce() {
        long stamp = stampedLock.readLock(); // lock state - not useful in this type of lock
        try {
            System.out.println("Read Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = true;
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            stampedLock.unlockRead(stamp);
            System.out.println("Read Lock released by: " + Thread.currentThread().getName());
        }
    }

    public void consume() {
        long stamp = stampedLock.writeLock();
        try {
            System.out.println("Write Lock acquired by: " + Thread.currentThread().getName());
            isAvailable = false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stampedLock.unlock(stamp);
            System.out.println("Write Lock released by: " + Thread.currentThread().getName());
        }
    }
}
