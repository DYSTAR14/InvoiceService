import java.util.List;

public class InvoiceGenerator {

    public double calculateCostOfCabRide(Ride ride) {
        double totalFare = ride.getDistance() * ride.getCabRide().getCostPerKm() + ride.getTime() * ride.getCabRide().getCostPerMin();
        return Math.max(totalFare, ride.getCabRide().getMinFare());
    }

    public InvoiceSummary calculateFare(List<Ride> userRidesInvoiceList) {
        double totalFare = 0;
        for (Ride ride:userRidesInvoiceList) {
            totalFare += this.calculateCostOfCabRide(ride);
        }
        return new InvoiceSummary(userRidesInvoiceList.size(),totalFare);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride:rides) {
            totalFare += this.calculateCostOfCabRide(ride);
        }
        return new InvoiceSummary(rides.length,totalFare);
    }
}
