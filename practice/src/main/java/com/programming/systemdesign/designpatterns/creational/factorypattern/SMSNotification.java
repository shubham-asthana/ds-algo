package com.programming.systemdesign.designpatterns.creational.factorypattern;

public class SMSNotification implements Notification {

    @Override
    public void sendNotification(String message) {
        System.out.println("Send SMS Notification: " + message);
    }
}
