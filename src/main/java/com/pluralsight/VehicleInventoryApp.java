package com.pluralsight;

import java.util.ArrayList;

public class VehicleInventoryApp {

    public static void main(String[] args) {
        Vehicle car = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);

        ArrayList<Vehicle> vehicles;
        vehicles = new ArrayList<Vehicle>();

        vehicles.add(car);

        Vehicle yourCar = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        vehicles.add(yourCar);

        for (Vehicle currentVehicle : vehicles) {
            System.out.println( currentVehicle.getColor() );
        }

        System.out.println();
    }
}
