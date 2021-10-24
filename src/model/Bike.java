package model;

public class Bike extends Vehicle {
    public Bike(String vehicleNumber, String vehicleColor) {
        super(vehicleNumber, vehicleColor);
        vehicleSize = VehicleSize.SMALL;
        vehicleType = VehicleType.BIKE;
    }

    @Override
    public VehicleSize getVehicleSize() {
        return vehicleSize;
    }

    @Override
    public VehicleType getVehicleType() {
        return vehicleType;
    }
}
