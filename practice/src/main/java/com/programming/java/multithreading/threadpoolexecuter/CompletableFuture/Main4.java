package com.programming.java.multithreading.threadpoolexecuter.CompletableFuture;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main4 {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10));

        CompletableFuture<Integer> asyncTask1 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread executing supply async: " + Thread.currentThread().getName());
            return 10;
        }, executor);

        CompletableFuture<String> asyncTask2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("Thread executing supply async: " + Thread.currentThread().getName());
            return "k ";
        }, executor);

        CompletableFuture<String> combinedObj = asyncTask1.thenCombineAsync(asyncTask2,
                (Integer val1, String val2) -> val1 + val2);

        try {
            System.out.println(combinedObj.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
