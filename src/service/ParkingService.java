package service;

import model.Slot;
import model.User;
import model.Vehicle;

public class ParkingService {
    int totalSlot;
    static Slot[] slots;
    public static int totalBookedSlot;

    public ParkingService(int totalSlot) {
        this.totalSlot = totalSlot;
        slots = new Slot[totalSlot];
        totalBookedSlot = 0;
        for (int i = 0; i < totalSlot; i++) {
            slots[i] = new Slot(i, true, null, null);
        }
    }

    public int getTotalBookedSlot() {
        return totalBookedSlot;
    }

    public void setTotalBookedSlot(int totalBookedSlot) {
        ParkingService.totalBookedSlot = totalBookedSlot;
    }

    public int getTotalSlot() {
        return totalSlot;
    }

    public void setTotalSlot(int totalSlot) {
        this.totalSlot = totalSlot;
    }

    public static Slot[] getSlots() {
        return slots;
    }

    public static void setSlots(Slot[] slots) {
        ParkingService.slots = slots;
    }

    public int bookCarInSlot(Vehicle vehicle, User user) {
        for (int i = 0; i < totalSlot; i++) {
            if (slots[i].isEmpty()) {
                totalBookedSlot++;
                slots[i].setParkVehicle(vehicle);
                slots[i].setUser(user);
                slots[i].setEmpty(false);
                return slots[i].getSlotNumber();
            }
        }

        return -1;
    }

    public void printSpots() {
        for (int i = 0; i < totalSlot; i++) {
            System.out.print(slots[i].getSlotNumber() + " " + slots[i].isEmpty() + " ");
            if (!slots[i].isEmpty())
                System.out.println(slots[i].getParkVehicle().getVehicleNumber());
            else
                System.out.println(" empty");
        }
    }

    public void removeCarFromSlot(String vehicleNumber) {
        for (int i = 0; i < totalSlot; i++) {
            if (!slots[i].isEmpty() && slots[i].getParkVehicle().getVehicleNumber().equals(vehicleNumber)) {
                totalBookedSlot--;
                slots[i].setEmpty(true);
                System.out.println("Car number: " + vehicleNumber + "  is Removed from Slot " + i);
                return;
            }
        }
        System.out.println("Car with number " + vehicleNumber + " is not in Parking System");
    }

}
