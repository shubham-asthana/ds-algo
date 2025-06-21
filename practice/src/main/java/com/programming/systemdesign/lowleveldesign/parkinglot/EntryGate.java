package com.programming.systemdesign.lowleveldesign.parkinglot;

import java.util.Date;
import java.util.UUID;

public class EntryGate {

    private int gateId;

    public EntryGate(int gateId) {
        this.gateId = gateId;
    }

    public Ticket generateTicket(Vehicle vehicle, ParkingSpot spot) {
        Ticket ticket = new Ticket();
        ticket.setTicketId(UUID.randomUUID().toString());
        ticket.setVehicle(vehicle);
        ticket.setEntryTime(new Date().getTime());
        ticket.setParkingSpot(spot);
        return ticket;
    }

    public int getGateId() {
        return gateId;
    }
}
