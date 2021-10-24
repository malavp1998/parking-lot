package model;

public class Car extends Vehicle{

    public Car(String vehicleNumber, String vehicleColor) {
        super(vehicleNumber, vehicleColor);
        vehicleSize = VehicleSize.MEDIUM;
        vehicleType = VehicleType.CAR;
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
