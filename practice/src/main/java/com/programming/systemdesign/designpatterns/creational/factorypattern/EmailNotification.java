package com.programming.systemdesign.designpatterns.creational.factorypattern;

public class EmailNotification implements Notification {

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending Email Notification: " + message);
    }
}
