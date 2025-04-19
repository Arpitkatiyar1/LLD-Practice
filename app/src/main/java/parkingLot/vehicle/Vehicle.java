package app.src.main.java.parkingLot.vehicle;

public class Vehicle {
    protected String licensePlate;
    protected VehicleType type;

    Vehicle(String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
    }
    public synchronized VehicleType getType() {
        return type;
    }
}
