package com.programming.systemdesign.designpatterns.behavioral.strategypattern;

public class Application {

    public static void main(String[] args) {
        Order order = new Order();

        ShippingStrategy flatRateStrategy = new FlatRateShipping(10.0);
        ShippingStrategy weightBasedStrategy = new WeightBasedShipping(2.5);
        ShippingStrategy distanceBasedStrategy = new DistanceBasedShipping(5.0);

        ShippingCostService shippingCostService = new ShippingCostService(flatRateStrategy);

        System.out.println("Calculating shipping cost for order using flat rate");
        System.out.println(
                "Shipping cost for order using flat rate: " + shippingCostService.calculateShippingCost(order));

        System.out.println("Calculating shipping cost for order using weight based");
        shippingCostService.setShippingStrategy(weightBasedStrategy);
        order.setTotalWeight(50);
        System.out.println(
                "Shipping cost for order using weight based: " + shippingCostService.calculateShippingCost(order));

        System.out.println("Calculating shipping cost for order using distance based");
        shippingCostService.setShippingStrategy(distanceBasedStrategy);
        order.setDestinationZone("ZoneA");
        System.out.println(
                "Shipping cost for order using distance based: " + shippingCostService.calculateShippingCost(order));
    }
}
