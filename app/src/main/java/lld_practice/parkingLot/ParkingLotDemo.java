package app.src.main.java.lld_practice.parkingLot;

import app.src.main.java.lld_practice.parkingLot.vehicle.Bike;
import app.src.main.java.lld_practice.parkingLot.vehicle.Car;
import app.src.main.java.lld_practice.parkingLot.vehicle.Truck;
import app.src.main.java.lld_practice.parkingLot.vehicle.Vehicle;

public class ParkingLotDemo {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getParkingLotInstance();
        parkingLot.addlevel(new Level(1, 100));
        parkingLot.addlevel(new Level(2, 80));

        Vehicle car = new Car("ABC123");
        Vehicle truck = new Truck("XYZ789");
        Vehicle motorcycle = new Bike("M1234");

        // Park vehicles
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(truck);
        parkingLot.parkVehicle(motorcycle);

        // Display availability
        parkingLot.isAvailable();

        // Unpark vehicle
        parkingLot.UnParkVehicle(motorcycle);

        // Display updated availability
        parkingLot.isAvailable();
    }
}
