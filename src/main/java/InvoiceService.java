public class InvoiceService {

    private RideRepository rideRepository;

//    InvoiceService(){
//        this.rideRepository = new RideRepository();
//    }
//    public void setRideRepository(RideRepository rideRepository){
//        this.rideRepository = rideRepository;
//    }

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
        rideRepository.addRides(userId,rides);
        return this.calculateFare(rideRepository.getRides(userId));
    }

//    public InvoiceSummary getInvoiceSummary(String userId) {
//        return this.calculateFare(rideRepository.getRides(userId));
//    }
}
