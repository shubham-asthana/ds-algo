package com.programming.java.multithreading.threadpoolexecuter.scheduledthreadpoolexecutor;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadpoolExecutorExample {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        executorService.schedule(() -> {
            System.out.println("Hello 1");
        }, 5, TimeUnit.SECONDS);

        Future<String> futureObj = executorService.schedule(() -> {
            return "Hello 2";
        }, 5, TimeUnit.SECONDS);

        try {
            System.out.println(futureObj.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        /*
         * Future<?> futureObj2 = executorService.scheduleAtFixedRate(() -> {
         * System.out.println("Hello 3");
         * }, 3, 5, TimeUnit.SECONDS);
         * 
         * try {
         * Thread.sleep(10000);
         * futureObj2.cancel(true);
         * } catch (InterruptedException e) {
         * e.printStackTrace();
         * }
         */

        /*
         * executorService.scheduleAtFixedRate(() -> {
         * System.out.println("Task picked");
         * try {
         * Thread.sleep(6000);
         * } catch (InterruptedException e) {
         * e.printStackTrace();
         * }
         * System.out.println("Task completed");
         * }, 1, 3, TimeUnit.SECONDS);
         */

        executorService.scheduleWithFixedDelay(() -> {
            System.out.println("Task picked");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Task completed");
        }, 1, 3, TimeUnit.SECONDS);

        System.out.println("Main thread completed");
    }
}
