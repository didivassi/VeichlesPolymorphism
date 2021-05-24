package com.vehicles.vehicle;

public class VehicleRental {

    final private float MIN_AMOUNT_FUEL_LEFT=20;
    final private float PRICE_CHARGED_FUEL=1.5f;
    //lista de stock
    private Vehicle[] vehicles;

    private int vehiclesCount;

    public VehicleRental(int numberOfVehicles){
        vehicles=new Vehicle[numberOfVehicles];
    }

    public void addVehicles(int numberOfVehicles, vehicleType type, String model){
        if(vehiclesCount+numberOfVehicles>vehicles.length){
            System.out.println("You don't have space for thar amount of vehicles");
            return;
        }
        int count = 0;
        for (int i = 0; i < vehicles.length ; i++) {
            if(count >= numberOfVehicles) {
                break;
            }
            if(vehicles[i]==null){
                vehicles[i]=createVehicle(type, model);
                vehiclesCount++;
                count++;
            }

        }
    }

    private Vehicle createVehicle(vehicleType type, String model){
        switch (type){
            case HYBRID_CAR:
                return new HybridCar(model);
            case MOTO:
                return new Moto(model);
            case CAR:
            default:
                return new Car(model);
        }
    }


    public Vehicle rentVehicle(vehicleType vehicleType){
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getType().equals(vehicleType) && !vehicle.isRented()) {
                vehicle.setRented(true);
                return vehicle;
            }
        }
        return null;
    }

    public void returnVehicle(Vehicle vehicle){
        //check payment
        double amount=makeBill(vehicle);
        vehicle.setRented(false);
        System.out.println("Your bill is " + amount);

    }

    public double makeBill(Vehicle vehicle){
            double amountToPay=0d;
            if(vehicle.getFuelOnTank() <  vehicle.fuelTankCapacity){
                amountToPay=(vehicle.fuelTankCapacity-vehicle.getFuelOnTank())*PRICE_CHARGED_FUEL;
                vehicle.refuel();
            }
            return amountToPay;
    }


    public void vehiclesList(){
        for (Vehicle vehicle:vehicles) {
            System.out.println(vehicle.toString());
        }

    }

}
