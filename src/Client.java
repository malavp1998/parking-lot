import model.*;
import service.ParkingService;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("              Write down the number of slot you want to create in Parking ");
        int totalSlotInParking = sc.nextInt();
        sc.nextLine();

        ParkingService parkingService = new ParkingService(totalSlotInParking);
        String cmd;
        do {
            System.out.println("   " +
                    "" +
                    "" +
                    "" +
                    " ");
            System.out.println("             PRESS 1 ::    For parking a new vehicle");
            System.out.println("             PRESS 2 ::    For removing a vehicle");
            System.out.println("             PRESS 3 ::    To watch all the  Records");
            System.out.println("             PRESS 4 ::    To Exit");
            cmd = sc.nextLine();


            if (cmd.equals("1")) {
                if (parkingService.getTotalSlot() == parkingService.getTotalBookedSlot()) {
                    System.out.println("             Parking lot if FULL              ");
                    continue;
                }
                System.out.println("                 Choose your Vehicle Type from below :-");
                System.out.println("                     1 : BIKE    ");
                System.out.println("                     2 : CAR     ");
                System.out.println("                     3 : BUS    ");
                int vehicleTypeNumber = sc.nextInt();
                sc.nextLine();
                System.out.println("                            Vehicle number     :");
                System.out.println("                            Vehicle colour     :");

                System.out.println("                            Your name          :");
                System.out.println("                            your mobile number :");


                cmd = sc.nextLine();
                String[] cmdList = cmd.split(" ");
                String vehicleNumber = cmdList[0];
                String vehicleColour = cmdList[1];
                String userName = cmdList[2];
                String userMobileNumber = cmdList[3];


                if (vehicleTypeNumber == 1) {
                    Bike bikeVehicle = new Bike(vehicleNumber, vehicleColour);
                    User user = new User(userName, userMobileNumber);

                    int assignedSlot = parkingService.bookCarInSlot(bikeVehicle, user);
                    System.out.println("              Your Booked Slot number is : " + assignedSlot + 1 + "  " + "Go and park your BIKE there :)");
                } else if (vehicleTypeNumber == 2) {
                    Car carVehicle = new Car(vehicleNumber, vehicleColour);

                    User user = new User(userName, userMobileNumber);

                    int assignedSlot = parkingService.bookCarInSlot(carVehicle, user);
                    System.out.println("              Your Booked Slot number is : " + assignedSlot + "  " + "Go and park your CAR there");
                } else if (vehicleTypeNumber == 3) {
                    Bus busVehicle = new Bus(vehicleNumber, vehicleColour);
                    User user = new User(userName, userMobileNumber);

                    int assignedSlot = parkingService.bookCarInSlot(busVehicle, user);
                    System.out.println("              Your Slot number is : " + assignedSlot + "  " + "Go and park your BUS there");
                } else {
                    System.out.println("              Warning : choose right option ");
                }

            }

            if (cmd.equals("2")) {
                System.out.println("              Write your Vehicle number");
                String vehicleNumber = sc.nextLine();

                parkingService.removeCarFromSlot(vehicleNumber);
            }
            if (cmd.equals("3")) {
                parkingService.printSpots();
            }


        }
        while (!cmd.equals("4"));

    }
}
