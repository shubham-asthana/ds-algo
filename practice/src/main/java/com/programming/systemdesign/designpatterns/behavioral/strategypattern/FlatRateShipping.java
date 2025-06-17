package com.programming.systemdesign.designpatterns.behavioral.strategypattern;

public class FlatRateShipping implements ShippingStrategy {

    private double rate;

    public FlatRateShipping(double rate) {
        this.rate = rate;
    }

    @Override
    public double calculateCost(Order order) {
        System.out.println("Calculating cost with flat rate strategy: $" + rate);
        return rate;
    }
}
