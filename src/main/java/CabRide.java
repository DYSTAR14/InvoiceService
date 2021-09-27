public enum CabRide {
    NORMAL(10, 1, 5),
    PREMIUM(15, 2, 20);

    private final double costPerKm;
    private final double costPerMin;
    private final double minFare;

    CabRide(double costPerKm, double costPerMin, double minFare) {
        this.costPerKm = costPerKm;
        this.costPerMin = costPerMin;
        this.minFare = minFare;
    }

    public double calculateCostOfCabRide(Ride ride) {
        double totalFare = ride.getDistance() * costPerKm + ride.getTime() * costPerMin;
        return Math.max(totalFare, minFare);
    }
}
