package com.programming.systemdesign.designpatterns.behavioral.strategypattern;

public class WeightBasedShipping implements ShippingStrategy {

    private double ratePerKg;

    public WeightBasedShipping(double ratePerKg) {
        this.ratePerKg = ratePerKg;
    }

    @Override
    public double calculateCost(Order order) {
        System.out.println("Calculating with weight based strategy: $" + ratePerKg + "/kg");
        return order.getTotalWeight() * ratePerKg;
    }
}
