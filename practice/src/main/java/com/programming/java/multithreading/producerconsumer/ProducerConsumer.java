package com.programming.java.multithreading.producerconsumer;

public class ProducerConsumer {

    public static void main(String[] args) {

        SharedResource sharedResource = new SharedResource();

        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                sharedResource.produceData(i);
            }
        });

        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                sharedResource.consumeData();
            }
        });

        producerThread.start();
        consumerThread.start();
    }
}
