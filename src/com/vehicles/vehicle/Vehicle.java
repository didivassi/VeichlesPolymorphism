package com.vehicles.vehicle;

public abstract class Vehicle {

    protected double fuelTankCapacity;
    protected String model;
    protected boolean rented;
    protected vehicleType type;
    protected double fuelOnTank;
    protected double consumptionRate;
    protected double maxSpeed;

    public Vehicle(double fuelTankCapacity, String model){
        this.fuelTankCapacity=fuelTankCapacity;
        this.model=model;
        rented=false;
        fuelOnTank=fuelTankCapacity;

    }


    public void drive(double time, double distance){
        if(distance/time >maxSpeed){
            System.out.println(("I can’t drive at this speed"));
            return;
        }
        double fuelConsumed = consumptionRate*distance;
        if(fuelConsumed>fuelOnTank){
            System.out.println("I don't have enough fuel to drive that long " + fuelConsumed + " " +fuelOnTank );
            return;
        }
        fuelOnTank -=  fuelConsumed;
    }

    public void refuel(){
        fuelOnTank=fuelTankCapacity;
        System.out.println("You have your tank full");

    }
    public void refuel(double amount){
        fuelOnTank+=amount;
        fuelOnTank = fuelOnTank > fuelTankCapacity ? fuelTankCapacity : fuelOnTank;
        System.out.println("Your fuel tank is now " + fuelOnTank);
    }

    @Override
    public String toString(){
        return model;
    }

    protected boolean isRented() {
        return rented;
    }

    protected void setRented(boolean rented) {
        this.rented = rented;
    }

    public vehicleType getType(){
        return type;
    }

    public double getFuelOnTank() {
        return fuelOnTank;
    }
}
