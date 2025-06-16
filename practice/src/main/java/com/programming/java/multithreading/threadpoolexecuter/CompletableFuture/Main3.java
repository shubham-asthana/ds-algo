package com.programming.java.multithreading.threadpoolexecuter.CompletableFuture;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main3 {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10));

        CompletableFuture<?> asyncTask1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread executing supply async: " + Thread.currentThread().getName());
            return "Hello ";
        }, executor).thenAcceptAsync((String val) -> {
            System.out.println("Out Value: " + val);
        }, executor);

        try {
            System.out.println(asyncTask1.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
