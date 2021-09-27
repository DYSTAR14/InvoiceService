import java.util.*;

public class RideRepository {
    Map<String, ArrayList<Ride>> rideRepositoryList;
    public RideRepository() {
        this.rideRepositoryList = new HashMap<>();
    }

//    public void dataEntryOfCabRide() {
//        ride = new Ride(2.0, 5, CabRide.NORMAL);
//        list = new ArrayList<>();
//        list.add(ride);
//        rideRepositoryList.put(11, list);
//
//        ride = new Ride(5.0, 4, CabRide.PREMIUM);
//        list = new ArrayList<>();
//        list.add(ride);
//        rideRepositoryList.put(12, list);
//
//        ride = new Ride(0.1, 1, CabRide.PREMIUM);
//        list = new ArrayList<>();
//        list = rideRepositoryList.get(11);
//        list.add(ride);
//        rideRepositoryList.put(11, list);
//
//        ride = new Ride(2.0, 8, CabRide.NORMAL);
//        list = new ArrayList<>();
//        list.add(ride);
//        rideRepositoryList.put(13, list);
//
//        ride = new Ride(8.0, 6, CabRide.PREMIUM);
//        list = new ArrayList<>();
//        list.add(ride);
//        rideRepositoryList.put(14, list);
//
//        ride = new Ride(7.0, 8, CabRide.NORMAL);
//        list = new ArrayList<>();
//        list = rideRepositoryList.get(13);
//        list.add(ride);
//        rideRepositoryList.put(13, list);
//    }

//    public List<Ride> getUserRidesInvoice() {
//        list = rideRepositoryList.get(this.id);
//        return list;
//    }

    public void addRides(String userId, Ride[] rides) {
        ArrayList<Ride> rideList = this.rideRepositoryList.get(userId);
        if(rideList != null)
            rideList.addAll(Arrays.asList(rides));
        else{
            rideList = new ArrayList<>(Arrays.asList(rides));
            rideRepositoryList.put(userId,rideList);
        }
    }

    public Ride[] getRides(String userId) {
        return this.rideRepositoryList.get(userId).toArray(new Ride[0]);
    }
}
