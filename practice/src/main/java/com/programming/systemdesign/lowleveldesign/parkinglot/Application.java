package com.programming.systemdesign.lowleveldesign.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {

		ParkingLot parkingLot = ParkingLot.getInstance();

		ParkingFloor floor1 = new ParkingFloor(1);
		List<ParkingSpot> parkingSpots1 = new ArrayList<>();
		parkingSpots1.add(new ParkingSpot(101, VehicleType.CAR, true, null));
		parkingSpots1.add(new ParkingSpot(102, VehicleType.BIKE, true, null));
		parkingSpots1.add(new ParkingSpot(103, VehicleType.TRUCK, true, null));
		parkingSpots1.add(new ParkingSpot(104, VehicleType.CAR, true, null));
		parkingSpots1.add(new ParkingSpot(105, VehicleType.BIKE, true, null));
		floor1.setParkingSpots(parkingSpots1);

		ParkingFloor floor2 = new ParkingFloor(2);
		List<ParkingSpot> parkingSpots2 = new ArrayList<>();
		parkingSpots2.add(new ParkingSpot(201, VehicleType.CAR, true, null));
		parkingSpots2.add(new ParkingSpot(202, VehicleType.BIKE, true, null));
		parkingSpots2.add(new ParkingSpot(203, VehicleType.BIKE, true, null));
		floor2.setParkingSpots(parkingSpots2);

		parkingLot.addFloor(floor1);
		parkingLot.addFloor(floor2);

		parkingLot.addEntryGate(new EntryGate(1));
		parkingLot.addExitGate(new ExitGate(1));

		Vehicle car1 = new Vehicle("UP32-RX-1234", VehicleType.CAR);
		Vehicle car2 = new Vehicle("UP32-RX-1654", VehicleType.CAR);
		Vehicle bike1 = new Vehicle("UP32-RX-7634", VehicleType.BIKE);
		Vehicle bike2 = new Vehicle("UP32-RX-9873", VehicleType.BIKE);
		Vehicle truck1 = new Vehicle("UP32-RX-1187", VehicleType.TRUCK);

		parkingLot.initializeSpotManager(new FindFirstSpotStrategy(), parkingLot.getFloors());

		try {
			Ticket ticket1 = parkingLot.parkVehicle(car1, 1);
			System.out.println("Vehicle: " + ticket1.getVehicle().getVehicleNo() + " is parked at parking spot: "
					+ ticket1.getParkingSpot().getSpotId());
			Ticket ticket2 = parkingLot.parkVehicle(car2, 1);
			System.out.println("Vehicle: " + ticket2.getVehicle().getVehicleNo() + " is parked at parking spot: "
					+ ticket2.getParkingSpot().getSpotId());
			Ticket ticket3 = parkingLot.parkVehicle(bike1, 1);
			System.out.println("Vehicle: " + ticket3.getVehicle().getVehicleNo() + " is parked at parking spot: "
					+ ticket3.getParkingSpot().getSpotId());
			Ticket ticket4 = parkingLot.parkVehicle(bike2, 1);
			System.out.println("Vehicle: " + ticket4.getVehicle().getVehicleNo() + " is parked at parking spot: "
					+ ticket4.getParkingSpot().getSpotId());
			Ticket ticket5 = parkingLot.parkVehicle(truck1, 1);
			System.out.println("Vehicle: " + ticket5.getVehicle().getVehicleNo() + " is parked at parking spot: "
					+ ticket5.getParkingSpot().getSpotId());

			// Waiting for 1 sec before exiting vehicles
			Thread.sleep(3000);
			System.out.println("Total parking fee for vehicle no.: " + ticket1.getVehicle().getVehicleNo() + " is: $"
					+ parkingLot.unparkVehicle(ticket1, 1));
			System.out.println("Total parking fee for vehicle no.: " + ticket4.getVehicle().getVehicleNo() + " is: $"
					+ parkingLot.unparkVehicle(ticket4, 1));
			System.out.println("Total parking fee for vehicle no.: " + ticket5.getVehicle().getVehicleNo() + " is: $"
					+ parkingLot.unparkVehicle(ticket5, 1));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
