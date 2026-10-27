package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

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

                searchForMakeModel(searchMakeModel, vehicles);
            }
            case "3" -> {
                System.out.println("Enter minimum search price: ");
                double priceMinimum = Double.parseDouble(myScanner.nextLine());

                System.out.println("Enter maxiumum search price: ");
                String priceMaximumText = myScanner.nextLine();
                double priceMaximum = Double.parseDouble(priceMaximumText);

                searchByPrice(priceMinimum, priceMaximum, vehicles);
            }
            case "4" -> {
                System.out.println("Enter the color you want: ");
                String searchColor = myScanner.nextLine();

                searchForColor(searchColor, vehicles);
            }
            case "5" -> {
                System.out.println("Enter a vehicle's info like this: 101123,Chevrolet Malibu,Black,50000,9700");
                String vehicleCsv = myScanner.nextLine();

                Vehicle newVehicle = parseVehicle(vehicleCsv);
                vehicles.add(newVehicle);
            }
            case "6" -> {
                System.out.println("Bye!");
            }
            default -> {
                System.out.println("That ain't an option, dummy.");
            }
        }
    }

    /**
     * Parses a string into a proper Vehicle object
     * @param vehicleCsv the String to convert
     * @return a new car!!!
     */
    public static Vehicle parseVehicle(String vehicleCsv) {
        // split up a string like:
        //   "101123,Chevrolet Malibu,Black,50000,9700"
        String[] parts = vehicleCsv.split(Pattern.quote(","));

        // Convert the first split part into the vehicle ID
        String vehicleIdText = parts[0];
        long vehicleId = Long.parseLong(vehicleIdText);

        String makeModel = parts[1];

        String color = parts[2];

        int odometerReading = Integer.parseInt(parts[3]);

        double price = Double.parseDouble(parts[4]);

        Vehicle newCar = new Vehicle(vehicleId, makeModel, color, odometerReading, price);

        return newCar;
    }

//    public String[] simpleSplit(String stringToSplit, String delimiter) {
//    }

    private static void searchByPrice(double priceMinimum, double priceMaximum, ArrayList<Vehicle> vehicles) {
        for (Vehicle currentVehicle : vehicles) {
            double vehiclePrice = currentVehicle.getPrice();

            if( (vehiclePrice >= priceMinimum) && (vehiclePrice <= priceMaximum) ) {
                currentVehicle.display();
            }

        }
    }

    private static void searchForColor(String searchColor, ArrayList<Vehicle> vehiclesToSearch) {
        for (Vehicle currentVehicle : vehiclesToSearch) {

            String currentColor = currentVehicle.getColor();
            if (currentColor.equals(searchColor)) {
                currentVehicle.display();
            }
        }
    }

    private static void searchForMakeModel(String searchMakeModel, ArrayList<Vehicle> vehicles) {
        for ( Vehicle x : vehicles) {
            String currentMakeModel = x.getMakeModel();
            if (currentMakeModel.equals(searchMakeModel)) {
                x.display();
            }
        }
    }

}
