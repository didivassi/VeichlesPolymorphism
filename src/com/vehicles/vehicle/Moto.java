package com.vehicles.vehicle;

public class Moto extends Vehicle{

    public Moto(String model){
        super(30, model);
        super.type= vehicleType.MOTO;
        super.consumptionRate=0.02;
        super.maxSpeed=100;
    }

    @Override
    public void drive(int time, int distance) {
        if(distance>80){
            System.out.println("You cant drive more than 80KM ");
            return;
        }
        super.drive(time, distance);
    }
}
