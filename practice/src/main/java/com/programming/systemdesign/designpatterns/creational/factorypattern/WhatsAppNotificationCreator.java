package com.programming.systemdesign.designpatterns.creational.factorypattern;

public class WhatsAppNotificationCreator extends NotificationCreatorFactory {

    @Override
    public Notification createNotification() {
        return new WhatsAppNotification();
    }
}
