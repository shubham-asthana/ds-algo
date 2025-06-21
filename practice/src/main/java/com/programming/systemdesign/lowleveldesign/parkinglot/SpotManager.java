package com.programming.systemdesign.lowleveldesign.parkinglot;

import java.util.List;

public class SpotManager {

    private SpotAssigmnentStrategy spotAssigmnentStrategy;
    private List<ParkingFloor> floors;

    public SpotManager(SpotAssigmnentStrategy strategy, List<ParkingFloor> floors) {
        this.spotAssigmnentStrategy = strategy;
        this.floors = floors;
    }

    public ParkingSpot assignSpot(Vehicle vehicle) {
        try {
            ParkingSpot spot = spotAssigmnentStrategy.findParkingSpot(vehicle, floors);
            spot.setAvailable(false);
            spot.setVehicle(vehicle);
            return spot;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void freeSpot(ParkingSpot spot) {
        spot.setAvailable(true);
        spot.setVehicle(null);
    }

}
