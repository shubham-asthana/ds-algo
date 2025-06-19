package com.programming.systemdesign.designpatterns.creational.factorypattern;

public abstract class NotificationCreatorFactory {

    public abstract Notification createNotification();

    public void send(String message) {
        Notification notification = createNotification();
        notification.sendNotification(message);
    }
}
