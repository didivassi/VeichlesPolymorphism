package com.vehicles;

import com.vehicles.vehicle.HybridCar;
import com.vehicles.vehicle.Vehicle;
import com.vehicles.vehicle.VehicleRental;
import com.vehicles.vehicle.vehicleType;

public class Main {

    public static void main(String[] args) {
	// write your code here
        VehicleRental devilsRental=new VehicleRental(10);

        devilsRental.addVehicles(3, vehicleType.CAR,"Z3");
        devilsRental.addVehicles(3, vehicleType.MOTO,"CBR100");
        devilsRental.addVehicles(3, vehicleType.HYBRID_CAR,"Prius");
        //sout ccant have
        devilsRental.addVehicles(3, vehicleType.HYBRID_CAR,"Prius");
        devilsRental.addVehicles(1, vehicleType.HYBRID_CAR,"Testarossa");
        devilsRental.addVehicles(1, vehicleType.HYBRID_CAR,"Testarossa");
        devilsRental.vehiclesList();

        Vehicle myVehicle=devilsRental.rentVehicle(vehicleType.HYBRID_CAR);

        if(myVehicle!=null){
            myVehicle.drive(1,120);
            myVehicle.refuel();
            myVehicle.drive(1,120);
            myVehicle.drive(10,250);
            myVehicle.drive(100,2500);
            myVehicle.drive(100,2500);
            myVehicle.drive(100,2500);
            myVehicle.drive(100,2500);
 

            System.out.println(((HybridCar) myVehicle).getBatteryLevel());
        }

    }
}
