package com.programming.java.multithreading.threadpoolexecuter.CompletableFuture;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10));

        CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(() -> {
            return "Task 1 Completed";
        }, executor);

        try {
            System.out.println(asyncTask1.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        CompletableFuture<String> asyncTask2 = CompletableFuture.supplyAsync(() -> {
            return "Concept and ";
        }, executor).thenApply(val -> val + "Coding");

        try {
            System.out.println(asyncTask2.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        CompletableFuture<String> asyncTask3 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Thread name of supply async: " + Thread.currentThread().getName());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "CONCEPT ";
        }, executor);

        CompletableFuture<String> asyncTask4 = asyncTask3.thenApply(val -> {
            System.out.println("Thread name of then apply: " + Thread.currentThread().getName());
            return "AND ";
        });

        try {
            System.out.println(asyncTask4.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        CompletableFuture<String> asyncTask5 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Thread name of supply async: " + Thread.currentThread().getName());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "CONCEPT ";
        }, executor).thenApplyAsync(val -> {
            System.out.println("Thread name of then apply async: " + Thread.currentThread().getName());
            return "AND ";
        });

        try {
            System.out.println(asyncTask5.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        CompletableFuture<String> asyncTask6 = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Thread name of supply async: " + Thread.currentThread().getName());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "CONCEPT ";
        }, executor).thenApplyAsync(val -> {
            System.out.println("Thread name of then apply async: " + Thread.currentThread().getName());
            return "AND ";
        }, executor);

        try {
            System.out.println(asyncTask6.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
