package parkingLot;

import java.util.ArrayList;
import java.util.List;

import parkingLot.vehicle.Vehicle;

public class ParkingLot {
    private final List<Level> levels;
    private static ParkingLot parkingLotInstance;
    
    private ParkingLot() {
        levels = new ArrayList<>();
    }       
    
    public static synchronized ParkingLot getParkingLotInstance() {
        if (parkingLotInstance == null)
            parkingLotInstance = new ParkingLot();

        return parkingLotInstance;
    }

    public synchronized void addlevel(Level level) {
        System.out.println("added a new level"+ level);
        levels.add(level);
    }

    public synchronized void parkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.isSpotAvailable(vehicle.getType())) {
                System.out.println(vehicle.getType() + " has been parked");
                level.parkVehicle(vehicle);
            } 
       }
    }

    public synchronized void UnParkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            System.out.println(vehicle.getType()+ " has been unParked");
            level.parkVehicle(vehicle);
        }
    }
    
    public synchronized boolean isAvailable() {
        for (Level level : levels) {
            if (level.isSpotAvailable()) {
                System.out.println("spot is available to Park vehcle");
                return true;
            }
        }
        System.out.println("spot is not available to Park vehcle");
        return false;
    }
    public synchronized boolean isAvailable(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.isSpotAvailable(vehicle.getType())) {
                System.out.println("spot is available to Park vehcle");
                return true;
            }                
        }
        System.out.println("spot is not available to Park vehcle");
        return false;
    }  
    
}
