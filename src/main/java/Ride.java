public class Ride {

    private final double distance;
    private final int time;
    private final CabRide cabRide;


    public Ride(double distance, int time, CabRide cabRide) {
        this.distance = distance;
        this.time = time;
        this.cabRide = cabRide;
    }

    public int getTime() {
        return time;
    }

    public double getDistance() {
        return distance;
    }

    public CabRide getCabRide() {
        return cabRide;
    }
}
