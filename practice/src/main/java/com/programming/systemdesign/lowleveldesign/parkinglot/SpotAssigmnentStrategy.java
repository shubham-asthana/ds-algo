package com.programming.systemdesign.lowleveldesign.parkinglot;

import java.util.List;

public interface SpotAssigmnentStrategy {

    ParkingSpot findParkingSpot(Vehicle vehicle, List<ParkingFloor> floors) throws Exception;
}
