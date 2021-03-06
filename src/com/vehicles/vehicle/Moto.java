package com.vehicles.vehicle;

public class Moto extends Vehicle{

    final private double MAX_DISTANCE=80;
    public Moto(String model){
        super(30, model);
        super.type= vehicleType.MOTO;
        super.consumptionRate=0.02;
        super.maxSpeed=100;
    }

    @Override
    public void drive(double time, double distance) {
        if(distance>MAX_DISTANCE){
            System.out.println("You cant drive more than "+MAX_DISTANCE+"KM ");
            return;
        }
        super.drive(time, distance);
    }
}
