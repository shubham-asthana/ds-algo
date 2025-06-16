package com.programming.java.multithreading.threadpoolexecuter.FutureCallable;

import java.util.List;

public class MyRunnable implements Runnable {

    private List<Integer> list;

    public MyRunnable(List<Integer> list) {
        this.list = list;
    }

    @Override
    public void run() {
        list.add(300);
    }

}
