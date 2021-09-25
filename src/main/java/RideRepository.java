import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RideRepository {
    private final int id;
    public RideRepository(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public static Map<Integer,List<Ride>> rideRepositoryList = new HashMap<>();
    List<Ride> list;
    Ride ride;


    public void dataEntryOfCabRide(){
        ride = new Ride(2.0, 5, CabRide.NORMAL );
        list = new ArrayList<Ride>();
        list.add(ride);
        rideRepositoryList.put(11,list);

        ride = new Ride(5.0, 4, CabRide.PREMIMUM);
        list = new ArrayList<Ride>();
        list.add(ride);
        rideRepositoryList.put(12,list);

        ride = new Ride(0.1, 1, CabRide.PREMIMUM);
        list = new ArrayList<Ride>();
        list = rideRepositoryList.get(11);
        list.add(ride);
        rideRepositoryList.put(11,list);

        ride = new Ride(2.0, 8, CabRide.NORMAL);
        list = new ArrayList<Ride>();
        list.add(ride);
        rideRepositoryList.put(13,list);

        ride = new Ride(8.0, 6, CabRide.PREMIMUM);
        list = new ArrayList<Ride>();
        list.add(ride);
        rideRepositoryList.put(14,list);

        ride = new Ride(7.0, 8, CabRide.NORMAL);
        list = new ArrayList<Ride>();
        list = rideRepositoryList.get(13);
        list.add(ride);
        rideRepositoryList.put(13,list);
    }

    public List<Ride> getUserRidesInvoice() {
        list = rideRepositoryList.get(this.id);
        return list;
    }
}
