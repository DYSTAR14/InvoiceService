public class InvoiceService {

    private RideRepository rideRepository;
    InvoiceService(){};
    InvoiceService(RideRepository rideRepository){
        this.rideRepository = rideRepository;
    }

    public double calculateFare(Ride ride) {
        return ride.getCabRide().calculateCostOfCabRide(ride);
    }

    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    public InvoiceSummary addRides(String userId, Ride[] rides) {
        Ride[] ride = rideRepository.addRides(userId,rides);
        return this.calculateFare(ride);
    }
}
