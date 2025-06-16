package com.programming.java.multithreading.threadpoolexecuter.CompletableFuture;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main2 {

    public static void main(String[] args) {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.HOURS, new ArrayBlockingQueue<>(10));

        CompletableFuture<String> asyncTask1 = CompletableFuture.supplyAsync(() -> {
            return "Hello ";
        }, executor).thenComposeAsync((String val) -> {
            return CompletableFuture.supplyAsync(() -> val + "World ");
        }, executor).thenComposeAsync((String val) -> {
            return CompletableFuture.supplyAsync(() -> val + "!!");
        }, executor);

        try {
            System.out.println(asyncTask1.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
