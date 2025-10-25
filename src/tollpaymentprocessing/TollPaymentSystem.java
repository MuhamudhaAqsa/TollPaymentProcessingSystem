package tollpaymentprocessing;

import java.util.*;

public class TollPaymentSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Initialize tolls
        List<Toll> tollPoints = new ArrayList<>();
        tollPoints.add(new Toll(0, Map.of("Car", 50, "Bike", 20, "Truck", 100)));
        tollPoints.add(new Toll(1, Map.of("Car", 60, "Bike", 25, "Truck", 120)));
        tollPoints.add(new Toll(2, Map.of("Car", 70, "Bike", 30, "Truck", 150)));

        // Map city names to toll indices
        Map<String, Integer> cityToIndex = Map.of(
                "Chennai", 0,
                "Bangalore", 1,
                "Mumbai", 2
        );

        Highway highway = new Highway(tollPoints);

        while (true) {
            System.out.println("\n--- Toll Payment System ---");
            System.out.println("1. Process Journey");
            System.out.println("2. Display Toll Details");
            System.out.println("3. Display Vehicle Details");
            System.out.println("4. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter vehicle number: ");
                    String vehicleNumber = scanner.nextLine();

                    System.out.print("Enter vehicle type (Car/Bike/Truck): ");
                    String vehicleType = scanner.nextLine();

                    System.out.print("Is VIP (true/false): ");
                    boolean isVIP = Boolean.parseBoolean(scanner.nextLine());

                    System.out.print("Enter start point: ");
                    String startCity = scanner.nextLine();
                    Integer start = cityToIndex.get(startCity);
                    if (start == null) {
                        System.out.println("Invalid start city!");
                        break;
                    }

                    System.out.print("Enter end point: ");
                    String endCity = scanner.nextLine();
                    Integer end = cityToIndex.get(endCity);
                    if (end == null) {
                        System.out.println("Invalid end city!");
                        break;
                    }

                    System.out.print("Enter tolls passed (comma-separated IDs): ");
                    String tollIdsInput = scanner.nextLine();
                    List<Integer> tollRoute = new ArrayList<>();
                    try {
                        for (String s : tollIdsInput.split(",")) {
                            tollRoute.add(Integer.parseInt(s.trim()));
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid toll IDs!");
                        break;
                    }

                    highway.processJourney(vehicleNumber, vehicleType, isVIP,
                            startCity, endCity, tollRoute);
                    break;

                case 2:
                    System.out.println("\n--- Toll Details ---");
                    highway.displayTollDetails();
                    break;

                case 3:
                    System.out.println("\n--- Vehicle Details ---");
                    highway.displayVehicleDetails();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
