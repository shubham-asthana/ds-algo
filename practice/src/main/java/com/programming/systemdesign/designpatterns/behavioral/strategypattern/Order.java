package com.programming.systemdesign.designpatterns.behavioral.strategypattern;

public class Order {

    private int totalWeight;

    private String destinationZone;

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }

    public String getDestinationZone() {
        return destinationZone;
    }

    public void setDestinationZone(String destinationZone) {
        this.destinationZone = destinationZone;
    }
}
