package com.programming.systemdesign.lowleveldesign.parkinglot;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingLot {

    private static ParkingLot instance;

    private List<ParkingFloor> floors;
    private List<EntryGate> entryGates;
    private List<ExitGate> exitGates;
    private SpotManager spotManager;

    private ParkingLot() {
        floors = new ArrayList<>();
        entryGates = new ArrayList<>();
        exitGates = new ArrayList<>();
    }

    public synchronized static ParkingLot getInstance() {
        if (null == instance) {
            instance = new ParkingLot();
        }
        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public void addEntryGate(EntryGate gate) {
        entryGates.add(gate);
    }

    public void addExitGate(ExitGate gate) {
        exitGates.add(gate);
    }

    public void initializeSpotManager(SpotAssigmnentStrategy spotAssigmnentStrategy, List<ParkingFloor> floors) {
        spotManager = new SpotManager(spotAssigmnentStrategy, floors);
    }

    public List<ParkingFloor> getFloors() {
        return floors;
    }

    public List<EntryGate> getEntryGates() {
        return entryGates;
    }

    public List<ExitGate> getExitGates() {
        return exitGates;
    }

    public Ticket parkVehicle(Vehicle vehicle, int entryGateId) throws Exception {
        Optional<EntryGate> entryGate = entryGates.stream().filter(gate -> gate.getGateId() == entryGateId).findFirst();
        if (entryGate.isPresent()) {
            ParkingSpot spot = spotManager.assignSpot(vehicle);
            if (null == spot) {
                throw new Exception("No available parking spot");
            }

            return entryGate.get().generateTicket(vehicle, spot);
        }
        throw new Exception("Invalid Entry Gate");
    }

    public double unparkVehicle(Ticket ticket, int exitGateId) throws Exception {
        Optional<ExitGate> exitGate = exitGates.stream().filter(gate -> gate.getGateId() == exitGateId).findFirst();
        if (exitGate.isPresent()) {
            spotManager.freeSpot(ticket.getParkingSpot());
            return exitGate.get().processExit(ticket);
        }
        throw new Exception("Invalid Exit Gate");
    }
}
