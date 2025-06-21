package com.programming.systemdesign.lowleveldesign.parkinglot;

import java.util.List;

public class ParkingFloor {

    private int floorNo;

    private List<ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNo) {
        this.floorNo = floorNo;
    }

    public int getFloorNo() {
        return floorNo;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpot> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }
}
