package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class VehicleInventoryApp {

    public static void main(String[] args) {
        Scanner myScanner = new Scanner(System.in);

        // Create an empty array list of Vehicle objects (not null, just empty - size 0)
        ArrayList<Vehicle> vehicles = loadVehicles();

        mainMenu(myScanner, vehicles);

        System.out.println("Thanks for using the Vehicle Inventory App!");
    }

    public static ArrayList<Vehicle> loadVehicles() {

//        FileReader fileReader = new FileReader("file.txt");

        ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

        // Create a vehicle object, chuck in variable named car
        Vehicle car = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        vehicles.add(car);

        Vehicle yourCar = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        vehicles.add(yourCar);

        // close file reader
        return vehicles;
    }

    private static void mainMenu(Scanner myScanner, ArrayList<Vehicle> vehicles) {
        String menuPrompt = """
                Main Menu
                1. List all vehicles
                2. Reports submenu
                3. Add a vehicle
                4. Quit
                Enter your command:""";

        boolean done = false;
        do {
            System.out.println(menuPrompt);
            String userInput = myScanner.nextLine();

            switch (userInput) {
                case "1" -> listAllVehicles(vehicles);
                case "2" -> reportsMenu(myScanner, vehicles);
                case "3" -> addVehicle(vehicles, myScanner);
                case "4" -> done = true;
                default -> System.out.println("That ain't an option, dummy.");
            }
        } while (!done);
    }

    private static void reportsMenu(Scanner myScanner, ArrayList<Vehicle> vehicles) {
        System.out.println("This is the reports menu.  I hope you liked it");
        String menuPrompt = """
                Reports Menu
                1. Search by make/model
                2. Search by price range
                3. Search by color
                4. Quit
                Enter your command:""";

        boolean done = false;
        do {
            System.out.println(menuPrompt);
            String userInput = myScanner.nextLine();

            switch (userInput) {
                case "1" -> searchForMakeModel(vehicles, myScanner);
                case "2" -> searchByPrice(vehicles, myScanner);
                case "3" -> searchForColor(vehicles, myScanner);
                case "4" -> done = true;
                default -> System.out.println("That ain't an option, dummy.");
            }
        }
        while (!done);
    }

    /**
     * Parses a string into a proper Vehicle object
     *
     * @param csvString the String to convert
     * @return a new car!!!
     */
    public static Vehicle parseVehicle(String csvString) {
        // split up a string like:
        //   "101123,Chevrolet Malibu,Black,50000,9700"
        String[] parts = csvString.split(Pattern.quote(","));

        // Convert the first split part into the vehicle ID
        String vIdText = parts[0];
        long vehicleId = Long.parseLong(vIdText);

        String makeModel = parts[1];

        String color = parts[2];

        int odometerReading = Integer.parseInt(parts[3]);

        double price = Double.parseDouble(parts[4]);

        Vehicle x = new Vehicle(vehicleId, makeModel, color, odometerReading, price);

        return x;
    }

//    public String[] simpleSplit(String stringToSplit, String delimiter) {
//    }

    private static void listAllVehicles(ArrayList<Vehicle> vehicles) {
        // Print a list of all the vehicles
        for (Vehicle currentVehicle : vehicles) {
            currentVehicle.display();
        }
    }

    private static void addVehicle(ArrayList<Vehicle> vehicles, Scanner scanner) {
        System.out.println("Enter a vehicle's info like this: 101123,Chevrolet Malibu,Black,50000,9700");
        String vehicleCsv = scanner.nextLine();

        Vehicle newVehicle = parseVehicle(vehicleCsv);
        vehicles.add(newVehicle);
    }

    private static void searchByPrice(ArrayList<Vehicle> vehicles, Scanner scanner) {
        System.out.println("Enter minimum search price: ");
        double priceMinimum = Double.parseDouble(scanner.nextLine());

        System.out.println("Enter maximum search price: ");
        String priceMaximumText = scanner.nextLine();
        double priceMaximum = Double.parseDouble(priceMaximumText);

        for (Vehicle currentVehicle : vehicles) {
            double vehiclePrice = currentVehicle.getPrice();

            if ((vehiclePrice >= priceMinimum) && (vehiclePrice <= priceMaximum)) {
                currentVehicle.display();
            }

        }
    }

    private static void searchForColor(ArrayList<Vehicle> vehiclesToSearch, Scanner scanner) {
        System.out.println("Enter the color you want: ");
        String searchColor = scanner.nextLine();

        for (Vehicle currentVehicle : vehiclesToSearch) {

            String currentColor = currentVehicle.getColor();
            if (currentColor.equals(searchColor)) {
                currentVehicle.display();
            }
        }
    }

//    public static void searchForMakeModel(HashMap<String, Vehicle> vehicleMap, Scanner scanner) {
//        System.out.println("Enter make/model to search for: ");
//        String searchMakeModel = scanner.nextLine();
//
//        Vehicle v = vehicleMap.get(searchMakeModel);
//        v.display();
//    }

    public static void searchForMakeModel(ArrayList<Vehicle> vehicles, Scanner scanner) {
        System.out.println("Enter make/model to search for: ");
        String searchMakeModel = scanner.nextLine();
        for (Vehicle v : vehicles) {
            String currentMakeModel = v.getMakeModel();
            if (currentMakeModel.equals(searchMakeModel)) {
                v.display();
            }
        }
    }

}
