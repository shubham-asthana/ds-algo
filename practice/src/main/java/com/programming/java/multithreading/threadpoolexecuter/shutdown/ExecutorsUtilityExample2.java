package com.programming.java.multithreading.threadpoolexecuter.shutdown;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsUtilityExample2 {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(() -> {
            try {
                Thread.sleep(15000);
            } catch (Exception ex) {

            }
            System.out.println("Task completed");
        });

        executorService.shutdownNow();

        System.out.println("Main thread completed");
    }
}
