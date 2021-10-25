package model;

public class Slot {

    int slotNumber;
    boolean isEmpty;
    Vehicle parkVehicle;
    User user;
    long entryTime;

    public Slot(int slotNumber, boolean isEmpty, Vehicle parkVehicle, User user, Long entryTime) {
        this.slotNumber = slotNumber;
        this.isEmpty = isEmpty;
        this.parkVehicle = parkVehicle;
        this.user = user;
        this.entryTime = entryTime;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public Vehicle getParkVehicle() {
        return parkVehicle;
    }

    public void setParkVehicle(Vehicle parkVehicle) {
        this.parkVehicle = parkVehicle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(long entryTime) {
        this.entryTime = entryTime;
    }
}
