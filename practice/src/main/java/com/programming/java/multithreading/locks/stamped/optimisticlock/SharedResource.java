package com.programming.java.multithreading.locks.stamped.optimisticlock;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    int a = 10;
    StampedLock stampedLock = new StampedLock();

    public void produce() {
        long stamp = stampedLock.tryOptimisticRead();
        try {
            System.out.println("Taken optimistic lock");
            a = 11;
            Thread.sleep(6000);
            if (stampedLock.validate(stamp)) {
                System.out.println("Updated ->a<- successfully");
            } else {
                System.out.println("Rollback of work");
                a = 10;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
    }

    public void consume() {
        long stamp = stampedLock.writeLock();
        System.out.println("Write Lock acquired by: " + Thread.currentThread().getName());
        try {
            System.out.println("Performing work");
            a = 9;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            stampedLock.unlockWrite(stamp);
            System.out.println("Write Lock released by: " + Thread.currentThread().getName());
        }
    }
}
