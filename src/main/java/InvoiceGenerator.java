import java.util.List;

public class InvoiceGenerator {

    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_COST_PER_KILOMETER = 10.0;
    private static final double MINIMUM_FARE = 5;

//    public double calculateFare(double distance, int time) {
//        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
//        return Math.max(totalFare, MINIMUM_FARE);
//    }
    public double calculateFare(double distance, int time, CabRide normal) {
        double totalFare = distance * MINIMUM_COST_PER_KILOMETER + time * COST_PER_TIME;
        return Math.max(totalFare, MINIMUM_FARE);
    }

    public double calculateCostOfCabRide(Ride ride) {
        double totalFare = ride.getDistance() * ride.getCabRide().getCostPerKm() + ride.getTime() * ride.getCabRide().getCostPerMin();
        return Math.max(totalFare, ride.getCabRide().getMinFare());
    }

    public InvoiceSummary calculateFare(List<Ride> userRidesInvoiceList) {
        double totalFare = 0;
        for (Ride ride:userRidesInvoiceList) {
            totalFare += this.calculateFare(ride.getDistance(), ride.getTime(), CabRide.NORMAL);
        }
        return new InvoiceSummary(userRidesInvoiceList.size(),totalFare);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride:rides) {
            totalFare += this.calculateFare(ride.getDistance(), ride.getTime(), CabRide.NORMAL);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }
}
