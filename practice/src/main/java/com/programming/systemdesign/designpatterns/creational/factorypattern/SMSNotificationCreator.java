package com.programming.systemdesign.designpatterns.creational.factorypattern;

public class SMSNotificationCreator extends NotificationCreatorFactory {

    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}
