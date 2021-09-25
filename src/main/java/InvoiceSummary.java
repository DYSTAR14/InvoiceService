public class InvoiceSummary {
    private final int numOfRide;
    private final double totalFare;
    private final double averageFare;

    public InvoiceSummary(int numOfRide, double totalFare) {
        this.numOfRide = numOfRide;
        this.totalFare = totalFare;
        this.averageFare = this.totalFare / this.numOfRide;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        InvoiceSummary summary = (InvoiceSummary) that;
        return numOfRide == summary.numOfRide &&
                Double.compare(summary.totalFare, totalFare) == 0 &&
                Double.compare(summary.averageFare, averageFare) == 0;
    }
}
