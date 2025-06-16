package com.programming.java.multithreading.threadpoolexecuter.shutdown;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsUtilityExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(() -> {
            try {
                Thread.sleep(5000);
            } catch (Exception ex) {

            }
            System.out.println("Task completed");
        });

        executorService.shutdown();
        try {
            boolean isTerminated = executorService.awaitTermination(2, TimeUnit.SECONDS); // blocks main thread
            System.out.println("Is Terminated: " + isTerminated);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main thread completed");
    }
}
