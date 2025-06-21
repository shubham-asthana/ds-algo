package com.programming.systemdesign.lowleveldesign.parkinglot;

public class ParkingSpot {

    private int spotId;

    private VehicleType spotType;

    private boolean isAvailable;

    private Vehicle vehicle;

    public ParkingSpot(int spotId, VehicleType spotType, boolean isAvailable, Vehicle vehicle) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.isAvailable = isAvailable;
        this.vehicle = vehicle;
    }

    public int getSpotId() {
        return spotId;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
