package com.programming.systemdesign.designpatterns.creational.factorypattern;

public class Application {

    public static void main(String[] args) {
        NotificationCreatorFactory creatorFactory;

        creatorFactory = new EmailNotificationCreator();
        creatorFactory.send("Welcome to the platform!");

        creatorFactory = new SMSNotificationCreator();
        creatorFactory.send("Your OTP to login is: 12345");

        creatorFactory = new WhatsAppNotificationCreator();
        creatorFactory.send("Connect with us on WhatsApp");
    }
}
