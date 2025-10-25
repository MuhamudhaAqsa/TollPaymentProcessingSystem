package tollpaymentprocessing;

import java.util.*;

public class Highway {
    List<Toll> tollPoints;           // List of all tolls on the highway
    Map<String, Vehicle> vehicleRecords;  // Map of vehicle number -> Vehicle object

    public Highway(List<Toll> tollPoints) {
        this.tollPoints = tollPoints;
        this.vehicleRecords = new HashMap<>();
    }

    // Process the journey for the regular path between start and end
    public void processJourney(String vehicleNumber, String vehicleType, boolean isVIP, String start, String end, List<Integer> tollRoute) {
        // If vehicle not present, create a new Vehicle object
        Vehicle vehicle = vehicleRecords.computeIfAbsent(vehicleNumber, vn -> new Vehicle(vn, vehicleType, isVIP));
        int totalAmount = 0;

        // Process each toll in the route
        for (int tollId : tollRoute) {
            Toll toll = tollPoints.get(tollId);  // use existing toll object
            int charge = toll.calculateToll(vehicleType, isVIP);  // calculate charge with VIP discount
            toll.recordVehicle(vehicle, charge);  // record vehicle passing through this toll
            totalAmount += charge;
        }

        // Create a Journey object and add to the vehicle's record
        Journey journey = new Journey(start, end, tollRoute, totalAmount);
        vehicle.addJourney(journey);

        System.out.println("Journey completed! Total Toll Paid: ₹" + totalAmount);
    }

    // Display details of all tolls
    public void displayTollDetails() {
        for (Toll toll : tollPoints) {
            toll.displayDetails();
            System.out.println(); // blank line for readability
        }
    }

    // Display details of all vehicles
    public void displayVehicleDetails() {
        for (Vehicle vehicle : vehicleRecords.values()) {
            vehicle.displayDetails();
            System.out.println(); // blank line for readability
        }
    }

    // Find shortest route considering circular path
    public List<Integer> findCircularRoute(int start, int end) {
        List<Integer> forwardRoute = new ArrayList<>();
        List<Integer> backwardRoute = new ArrayList<>();
        int totalTolls = tollPoints.size();

        // Forward route
        for (int i = start; i != end; i = (i + 1) % totalTolls) {
            forwardRoute.add(i);
        }
        forwardRoute.add(end);

        // Backward route
        for (int i = start; i != end; i = (i - 1 + totalTolls) % totalTolls) {
            backwardRoute.add(i);
        }
        backwardRoute.add(end);

        return forwardRoute.size() <= backwardRoute.size() ? forwardRoute : backwardRoute;
    }

    // Calculate total toll for a regular route (start <= end)
    public int calculateRegularTollForRoute(int start, int end, String vehicleType, boolean isVIP) {
        int totalCost = 0;

        if (start <= end) {
            for (int i = start; i <= end; i++) {
                Toll toll = tollPoints.get(i);
                totalCost += toll.calculateToll(vehicleType, isVIP);
            }
        } else { // wrap around
            for (int i = start; i < tollPoints.size(); i++) {
                Toll toll = tollPoints.get(i);
                totalCost += toll.calculateToll(vehicleType, isVIP);
            }
            for (int i = 0; i <= end; i++) {
                Toll toll = tollPoints.get(i);
                totalCost += toll.calculateToll(vehicleType, isVIP);
            }
        }
        return totalCost;
    }

    // Calculate total toll for a specific route
    public int calculateTollForRoute(List<Integer> tollRoute, String vehicleType, boolean isVIP) {
        int totalCost = 0;
        for (int tollId : tollRoute) {
            Toll toll = tollPoints.get(tollId);
            totalCost += toll.calculateToll(vehicleType, isVIP);
        }
        return totalCost;
    }
}
