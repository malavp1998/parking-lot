package model;

public class Bus extends Vehicle {

    public Bus(String vehicleNumber, String vehicleColor) {
        super(vehicleNumber, vehicleColor);
        vehicleSize = VehicleSize.LARGE;
        vehicleType = VehicleType.BUS;
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
