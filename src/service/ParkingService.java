package service;

import model.*;

import java.util.Calendar;

public class ParkingService {
    int totalSlot;
    static Slot[] slots;
    public static int totalBookedSlot;

    public ParkingService(int totalSlot) {
        this.totalSlot = totalSlot;
        slots = new Slot[totalSlot];
        totalBookedSlot = 0;
        for (int i = 0; i < totalSlot; i++) slots[i] = new Slot(i, true, null, null, (long) 0);
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
                slots[i].setEntryTime(Calendar.getInstance().getTimeInMillis());
                return slots[i].getSlotNumber();
            }
        }
        return -1;
    }

    public void printSpots() {
        for (int i = 0; i < totalSlot; i++) {
            System.out.println("Slot Number : " + slots[i].getSlotNumber() + ", isEmpty : " + slots[i].isEmpty());
            if (!slots[i].isEmpty()) {
                System.out.println("   Slot Details    :: " + "Size : " + slots[i].getParkVehicle().getVehicleSize() + ", " + " Type :" + slots[i].getParkVehicle().getVehicleType());
                System.out.println("   Owner  Details  :: " + "Name  : " + slots[i].getUser().getUseName() + ", " + "Mobile No. : " + slots[i].getUser().getMobileNumber());
                System.out.println("   Vehicle Details :: " + "Vehicle No. : " + slots[i].getParkVehicle().getVehicleNumber() + ", " + "Vehicle Colour : " + slots[i].getParkVehicle().getVehicleColor());
                System.out.println();
                System.out.println();

            } else
                System.out.println();
        }
    }

    public void removeCarFromSlot(String vehicleNumber) {
        for (int i = 0; i < totalSlot; i++) {
            if (!slots[i].isEmpty() && slots[i].getParkVehicle().getVehicleNumber().equals(vehicleNumber)) {
                totalBookedSlot--;
                slots[i].setEmpty(true);

                if (slots[i].getParkVehicle() instanceof Car) {
                    System.out.println("Car with number: " + vehicleNumber + "  is Removed from Slot " + i);
                    int time = (int) (Calendar.getInstance().getTimeInMillis() - slots[i].getEntryTime()) / (60 * 1000);
                    System.out.println("Charge to be paid : Rs" + new ChargeService().calculateCarCharge(time));
                }
                if (slots[i].getParkVehicle() instanceof Bus) {
                    System.out.println("Bus with number: " + vehicleNumber + "  is Removed from Slot " + i);
                    int time = (int) (Calendar.getInstance().getTimeInMillis() - slots[i].getEntryTime()) / (60 * 1000);
                    System.out.println("Charge to be paid : Rs" + new ChargeService().calculateBusCharge(time));
                }
                if (slots[i].getParkVehicle() instanceof Bike) {
                    System.out.println("Bike with number: " + vehicleNumber + "  is Removed from Slot " + i);
                    int time = (int) (Calendar.getInstance().getTimeInMillis() - slots[i].getEntryTime()) / (60 * 1000);
                    System.out.println("Charge to be paid : Rs" + new ChargeService().calculateBikeCharge(time));
                }
                return;
            }
        }
        System.out.println("Vehicle with number " + vehicleNumber + " is not in Parking System");
    }

}
