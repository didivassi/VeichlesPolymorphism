package com.vehicles.vehicle;

public class HybridCar extends Car{

    private double batteryLevel=100;
    final private double batteryConsumptionRate=0.01;

    public HybridCar(String model){
        super(model);
        super.type= vehicleType.HYBRID_CAR;
    }

    @Override
    public void drive(int time, int distance) {
        if(distance/time <=25){
            double batteryConsumed = batteryConsumptionRate*distance;
            if(batteryConsumed>batteryLevel){
                System.out.println("I don't have enough battery to drive that long");
                System.out.println("Switch to car mode");
                super.drive(time, distance);
                return;
            }
            batteryLevel-=batteryConsumed;
            System.out.println(("You are now on battery"));
            return;
        }
        super.drive(time, distance);
    }

    public void rechargeBattery(){
        batteryLevel=100;
        System.out.println("Your battery is now full");
    }
    public void rechargeBattery(double amount){
        batteryLevel+=amount;
        batteryLevel = batteryLevel > 100 ? 100 : batteryLevel;
        System.out.println("Your battery is now " +  batteryLevel);
    }

    public double getBatteryLevel() {
        return batteryLevel;
    }
}
