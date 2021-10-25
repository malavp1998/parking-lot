package model;

public abstract class Vehicle {
    String vehicleNumber;
    String vehicleColor;
    VehicleSize vehicleSize;
    VehicleType vehicleType;

    public Vehicle(String vehicleNumber, String vehicleColor) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleColor = vehicleColor;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public abstract VehicleSize getVehicleSize();

    public abstract VehicleType getVehicleType();

}