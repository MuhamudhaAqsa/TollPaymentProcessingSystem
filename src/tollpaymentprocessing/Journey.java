package tollpaymentprocessing;

import java.util.*;

class Journey {
    String startPoint;
    String endPoint;
    List<Integer> tollsPassed;  // Tolls passed during the journey
    int amountPaid;  // Total toll charges paid

    public Journey(String startPoint, String endPoint, List<Integer> tollsPassed, int amountPaid) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.tollsPassed = tollsPassed;
        this.amountPaid = amountPaid;
    }
}
