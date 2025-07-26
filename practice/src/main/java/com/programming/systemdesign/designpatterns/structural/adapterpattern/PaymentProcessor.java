package com.programming.systemdesign.designpatterns.structural.adapterpattern;

public interface PaymentProcessor {

    void processPayment(double amount, String currency);

    boolean isPaymentSuccessful();

    String getTransactionId();
}
