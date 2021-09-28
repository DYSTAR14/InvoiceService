import java.util.*;

public class RideRepository {
    Map<String, ArrayList<Ride>> rideRepositoryList;
    public RideRepository() {
        this.rideRepositoryList = new HashMap<>();
    }

    public Ride[] addRides(String userId, Ride[] rides) {
        ArrayList<Ride> rideList = this.rideRepositoryList.get(userId);
        if(rideList != null)
            rideList.addAll(Arrays.asList(rides));
        else{
            rideList = new ArrayList<>(Arrays.asList(rides));
            rideRepositoryList.put(userId,rideList);
        }
        return this.rideRepositoryList.get(userId).toArray(new Ride[0]);
    }
}
