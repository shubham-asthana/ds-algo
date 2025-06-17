package com.programming.systemdesign.designpatterns.behavioral.strategypattern;

public class ShippingCostService {

    private ShippingStrategy shippingStrategy;

    public ShippingCostService(ShippingStrategy shippingStrategy) {
        this.shippingStrategy = shippingStrategy;
    }

    public void setShippingStrategy(ShippingStrategy shippingStrategy) {
        System.out.println("Shipping strategy changed to " + shippingStrategy.getClass().getSimpleName());
        this.shippingStrategy = shippingStrategy;
    }

    public double calculateShippingCost(Order order) {
        if (null == shippingStrategy) {
            throw new IllegalStateException("Shipping stratgey not set");
        }
        double cost = shippingStrategy.calculateCost(order);
        System.out.println("Cost of shipping calculated for strategy: " + shippingStrategy.getClass().getSimpleName()
                + " is: " + cost);
        return cost;
    };
}
