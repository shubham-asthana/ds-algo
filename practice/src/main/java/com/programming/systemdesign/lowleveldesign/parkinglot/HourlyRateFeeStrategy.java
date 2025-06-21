package com.programming.systemdesign.lowleveldesign.parkinglot;

public class HourlyRateFeeStrategy implements FeeStrategy {

    @Override
    public double calculateFee(Ticket ticket, long exitTime) {
        double fee = 0.0;
        double seconds = Math.ceil((exitTime - ticket.getEntryTime()) / (1000));
        switch (ticket.getVehicle().getVehicleType()) {
            case CAR:
                fee = seconds * 20;
                break;
            case BIKE:
                fee = seconds * 10;
                break;
            case TRUCK:
                fee = seconds * 40;
                break;
        }
        return fee;
    }
}
