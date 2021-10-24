import model.*;
import service.ParkingService;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" write down the number of slot you want to create in our Parking ");
        int totalSlotInParking = sc.nextInt();
        sc.nextLine();

        ParkingService parkingService = new ParkingService(totalSlotInParking);
        String cmd;
        do {

            System.out.println("....................  .for parking a vehicle press 1 :");
            System.out.println(".....................  for taking a vehicle press 2 :");
            System.out.println(".....................  for exit : exit");
            cmd = sc.nextLine();


            if (cmd.equals("1")) {
                if (parkingService.getTotalSlot() == parkingService.getTotalBookedSlot()) {
                    System.out.println("sorry there is not any empty Slot");
                    continue;
                }
                System.out.println("Choose your Vehicle Type form bolow");
                System.out.println("    1 : BIKE");
                System.out.println("    2 : CAR");
                System.out.println("    3 : BUS");
                int vehicleTypeNumber = sc.nextInt();
                sc.nextLine();
                System.out.println(".....................  Vehicle number");
                System.out.println(".....................  Vehicle colour");

                System.out.println(".....................  Your name");
                System.out.println(".....................  your mobile number");


                cmd = sc.nextLine();
                String[] cmdList = cmd.split(" ");
                String vehicleNumber = cmdList[0];
                String vehicleColour = cmdList[1];
                String userName = cmdList[2];
                String userMobileNumber = cmdList[3];

                //System.out.println(name+" "+ mobileNumber+" "+vehicleNumber+" "+vehicleColour);
                if (vehicleTypeNumber == 1) {
                    Bike bikeVehicle = new Bike(vehicleNumber, vehicleColour);
                    System.out.println(bikeVehicle.getVehicleNumber());
                    User user = new User(userName, userMobileNumber);

                    int assignedSlot = parkingService.bookCarInSlot(bikeVehicle, user);
                    System.out.println("Your Slot number is : " + assignedSlot + " .... " + "Go and park your CAR there");
                }

                else if (vehicleTypeNumber == 2) {
                    Car carVehicle = new Car(vehicleNumber, vehicleColour);

                    User user = new User(userName, userMobileNumber);

                    int assignedSlot = parkingService.bookCarInSlot(carVehicle, user);
                    System.out.println("Your Slot number is : " + assignedSlot + " .... " + "Go and park your CAR there");
                }
               else if (vehicleTypeNumber == 3) {
                    Bus busVehicle = new Bus(vehicleNumber, vehicleColour);
                    User user = new User(userName, userMobileNumber);

                    int assignedSlot = parkingService.bookCarInSlot(busVehicle, user);
                    System.out.println("Your Slot number is : " + assignedSlot + " .... " + "Go and park your BUS there");
                }
               else {
                    System.out.println("Warning : choose right option ");
                }

            }

            if (cmd.equals("2")) {
                System.out.println("Write your Vehicle number");
                String vehicleNumber = sc.nextLine();

                parkingService.removeCarFromSlot(vehicleNumber);
            }
            if (cmd.equals("3")) {
                parkingService.printSpots();
            }

        }
        while (!cmd.equals("exit"));

    }
}
