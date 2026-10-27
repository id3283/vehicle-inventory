package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class VehicleInventoryApp {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        // Create an empty array list of Vehicle objects (not null, just empty - size 0)
        ArrayList<Vehicle> vehicles;
        vehicles = new ArrayList<Vehicle>();

        // Create a vehicle object, chuck in variable named car
        Vehicle car = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        // add that object to my (previously empty) array list
        vehicles.add(car);

        // Add another one, same deal
        Vehicle yourCar = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        vehicles.add(yourCar);

        // 🤯
        // Loop through the array list of Vehicles called: vehicles
        for (Vehicle currentVehicle : vehicles) {
//            System.out.println( currentVehicle.getColor() );
        }

        String menuPrompt = """
                What do you want to do?
                1 - List all vehicles
                2 - Search by make/model
                3 - Search by price range
                4 - Search by color
                5 - Add a vehicle
                6 - Quit
                Enter your command:""";
        System.out.println(menuPrompt);

        String userInput = myScanner.nextLine();

        switch (userInput) {
            case "1" -> {
                // Print a list of all the vehicles
                for (Vehicle currentVehicle : vehicles) {
                    currentVehicle.display();
                }
            }
            case "2" -> {
                System.out.println("Enter make/model to search for: ");
                String searchMakeModel = myScanner.nextLine();
                searchVehicles(searchMakeModel, vehicles);
            }

        }

    }

    private static void searchVehicles(String searchMakeModel, ArrayList<Vehicle> vehicles) {
        for ( Vehicle x : vehicles) {
            String currentMakeModel = x.getMakeModel();
            if (currentMakeModel.equals(searchMakeModel)) {
                x.display();
            }
        }
    }

}
