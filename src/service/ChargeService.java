package service;

public class ChargeService {
    int busChargePerMinute = 30;
    int carChargePerMinute = 20;
    int bikeChargePerMinute = 10;


    public int calculateBusCharge(int timeInMinute) {
        return (int) (busChargePerMinute * timeInMinute);
    }

    public int calculateCarCharge(int timeInMinute) {
        return (int) (carChargePerMinute * timeInMinute);
    }

    public int calculateBikeCharge(int timeInMinute) {
        return (int) (bikeChargePerMinute * timeInMinute);
    }

}
