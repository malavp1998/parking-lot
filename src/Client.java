import model.User;
import model.Vehicle;
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
        do{

            System.out.println("....................  .for parking a vehicle press 1 :");
            System.out.println(".....................  for taking a vehicle press 2 :");
            System.out.println(".....................  for exit : exit");
            cmd = sc.nextLine();


            if( cmd.equals("1"))
            {
                if(parkingService.getTotalSlot() == parkingService.getTotalBookedSlot()) {
                    System.out.println("sorry there is not any slot empty");
                    continue;
                }
                System.out.println(".....................  Your name");
                System.out.println(".....................  your mobile number");
                System.out.println(".....................  Vehicle number");
                System.out.println(".....................  Vehicle colour");

                cmd = sc.nextLine();
                String[] cmdList = cmd.split(" ");
                String userName = cmdList[0];
                String userMobileNumber = cmdList[1];
                String vehicleNumber  =  cmdList[2];
                String vehicleColour = cmdList[3];
                //System.out.println(name+" "+ mobileNumber+" "+vehicleNumber+" "+vehicleColour);

                Vehicle vehicle =  new Vehicle(vehicleNumber, vehicleColour);
                User user = new User(userName, userMobileNumber);

                int assignedSlot =  parkingService.bookCarInSlot(vehicle, user);
                System.out.println("Your Slot number is : " +assignedSlot+" .... "+"Go and park your car there");

            }

            if(cmd.equals("2"))
            {
                System.out.println("Write your Vehicle number");
                String vehicleNumber =  sc.nextLine();

                parkingService.removeCarFromSlot(vehicleNumber);
            }
            if(cmd.equals("3"))
            {
                parkingService.printSpots();
            }

        }
        while(!cmd.equals("exit"));

    }
}
