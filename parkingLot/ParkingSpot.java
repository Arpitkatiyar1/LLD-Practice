package parkingLot;

import parkingLot.vehicle.Vehicle;
import parkingLot.vehicle.VehicleType;

public class ParkingSpot {
    private final int spotNumber;
    private final VehicleType vehicleType;
    private Vehicle parkedVehicle;

    ParkingSpot(int spotNumber, VehicleType vehicleType) {
        this.spotNumber = spotNumber;
        this.vehicleType = vehicleType;
    }

    public synchronized boolean isAvailable() {
        return parkedVehicle == null;
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        if(isAvailable() && vehicle.getType()==this.vehicleType)
            this.parkedVehicle = vehicle;
        else
            throw new IllegalArgumentException("Invalid Vehicle type of space is occupied");
    }

    public synchronized void unParkVehicle() {
        parkedVehicle = null;
    }

    public synchronized int getSpotNumber() {
        return spotNumber;
    }

    public synchronized VehicleType getVehicleType() {
        return vehicleType;
    }

    public synchronized Vehicle getParkedVehicle() {
        return parkedVehicle;
    }  
}
