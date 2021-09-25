public enum CabRide {
    NORMAL(10,1,5),
    PREMIMUM(15,2,20);

    public double getCostPerKm() {
        return costPerKm;
    }

    private final double costPerKm;

    public double getCostPerMin() {
        return costPerMin;
    }

    private final double costPerMin;

    public double getMinFare() {
        return minFare;
    }

    private final double minFare;

    CabRide(double costPerKm, double costPerMin, double minFare){
        this.costPerKm = costPerKm;
        this.costPerMin = costPerMin;
        this.minFare = minFare;
    }
}
