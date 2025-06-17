package com.programming.systemdesign.designpatterns.behavioral.strategypattern;

public interface ShippingStrategy {

    double calculateCost(Order order);
}
