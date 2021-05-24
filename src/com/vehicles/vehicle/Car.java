package com.vehicles.vehicle;

public class Car extends Vehicle {


    public Car(String model){
        super(40,model);
        super.type= vehicleType.CAR;
        super.consumptionRate=0.05;
        super.maxSpeed=120;
    }
}
