package com.programming.java.multithreading.threadpoolexecuter.FutureCallable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 10, TimeUnit.MINUTES,
                new ArrayBlockingQueue<>(10));

        List<Integer> output = new ArrayList<>();
        Future<List<Integer>> futureObj1 = threadPoolExecutor.submit(new MyRunnable(output), output);

        try {
            futureObj1.get();
            // First way
            System.out.println(output.get(0));

            // Second way - in case I need to rely on what future obj returns
            List<Integer> result = futureObj1.get();
            System.out.println(result.get(0));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        // Use case 3 - cleaner
        Future<List<Integer>> futureObj2 = threadPoolExecutor.submit(() -> {
            List<Integer> out = new ArrayList<>();
            out.add(400);
            return out;
        });

        try {
            List<Integer> result = futureObj2.get();
            System.out.println(result.get(0));
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
    }
}
