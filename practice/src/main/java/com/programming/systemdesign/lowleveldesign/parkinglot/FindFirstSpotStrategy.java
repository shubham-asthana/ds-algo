package com.programming.systemdesign.lowleveldesign.parkinglot;

import java.util.List;

public class FindFirstSpotStrategy implements SpotAssigmnentStrategy {

    @Override
    public ParkingSpot findParkingSpot(Vehicle vehicle, List<ParkingFloor> floors) throws Exception {
        for (ParkingFloor floor : floors) {
            List<ParkingSpot> spots = floor.getParkingSpots();
            for (ParkingSpot spot : spots) {
                if (spot.isAvailable() && spot.getSpotType().equals(vehicle.getVehicleType())) {
                    return spot;
                }
            }
        }
        throw new Exception("Sorry no spot available for your vehicle of type - " + vehicle.getVehicleType());
    }

}
