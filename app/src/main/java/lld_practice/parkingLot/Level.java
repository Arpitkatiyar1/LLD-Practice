package app.src.main.java.lld_practice.parkingLot;

import java.util.ArrayList;
import java.util.List;

import app.src.main.java.lld_practice.parkingLot.vehicle.Vehicle;
import app.src.main.java.lld_practice.parkingLot.vehicle.VehicleType;

public class Level {
    private final int floor;
    private final List<ParkingSpot> parkingspots;

    public Level(int floor, int numSpot) {
        this.floor = floor;
        this.parkingspots = new ArrayList<>(numSpot);
        double carSpotFraction = 0.5,
                bikeSpotFraction = 0.1,
                truckSpotFraction = 0.4;

        int numcarspots = (int) (numSpot * carSpotFraction);
        int numbikespots = (int) (numSpot * bikeSpotFraction);
        int numtruckspots = (int) (numSpot * truckSpotFraction);

        for (int iterator = 1; iterator <= numbikespots; iterator++) {
            parkingspots.add(new ParkingSpot(iterator, VehicleType.CAR));
        }
        for (int iterator = numbikespots + 1; iterator <= numbikespots + numcarspots; iterator++) {
            parkingspots.add(new ParkingSpot(iterator, VehicleType.CAR));
        }
        for (int iterator = numbikespots + numcarspots + 1; iterator <= numbikespots + numcarspots
                + numtruckspots; iterator++) {
            parkingspots.add(new ParkingSpot(iterator, VehicleType.CAR));
        }
    }
    
    public synchronized void parkVehicle(Vehicle vehicle){
        for (ParkingSpot parkingSpot : parkingspots) {
            if (parkingSpot.isAvailable() && parkingSpot.getVehicleType() == vehicle.getType()) {
                parkingSpot.parkVehicle(vehicle);
            }
        }
    }
    public int getFloor() {
        return floor;
    }
    public List<ParkingSpot> getParkingspots() {
        return parkingspots;
    }
    public synchronized void unParkVehicle(Vehicle vehicle){
        for (ParkingSpot parkingSpot : parkingspots) {
            if(parkingSpot.getParkedVehicle()==vehicle) parkingSpot.unParkVehicle();
        }
    }

    public synchronized boolean isSpotAvailable(VehicleType vehicleType){
        for (ParkingSpot parkingSpot : parkingspots) {
            if (parkingSpot.isAvailable() && parkingSpot.getVehicleType() == vehicleType)
                return true;
        }
        return false;
    }

    public synchronized boolean isSpotAvailable(){
        for (ParkingSpot parkingSpot : parkingspots) {
            if (parkingSpot.isAvailable())
                return true;
        }
        return false;
    }
}
