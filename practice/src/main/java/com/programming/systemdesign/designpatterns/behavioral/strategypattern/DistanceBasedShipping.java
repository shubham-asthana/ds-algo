package com.programming.systemdesign.designpatterns.behavioral.strategypattern;

public class DistanceBasedShipping implements ShippingStrategy {

    private double ratePerKm;

    public DistanceBasedShipping(double ratePerKm) {
        this.ratePerKm = ratePerKm;
    }

    @Override
    public double calculateCost(Order order) {
        System.out.println("Calculating with distance based strategy for zone: " + order.getDestinationZone());
        double cost = 0;
        switch (order.getDestinationZone()) {
            case "ZoneA":
                cost = ratePerKm * 5.0;
                break;
            case "ZoneB":
                cost = ratePerKm * 7.0;
                break;
            default:
                cost = ratePerKm * 10.0;
                break;
        }
        return cost;
    }
}
