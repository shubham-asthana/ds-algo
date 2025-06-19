package com.programming.systemdesign.designpatterns.creational.factorypattern;

public class EmailNotificationCreator extends NotificationCreatorFactory {

    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}
