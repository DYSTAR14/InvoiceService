
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
//import org.mockito.junit.MockitoJUnit;
//import org.mockito.junit.MockitoRule;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InvoiceServiceTest {

//    @Rule
//    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    RideRepository rideRepository;

    @InjectMocks
    InvoiceService invoiceService;

    @BeforeEach
    public void setUp() {
        invoiceService = new InvoiceService();
        rideRepository = new RideRepository();
    }

    @Test
    public void givenDistanceAndTime_ShouldRetrunTotalFare() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceService.calculateFare(new Ride(distance, time, CabRide.NORMAL));
        Assertions.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenLessDistanceOrTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        double fare = invoiceService.calculateFare(new Ride(distance, time, CabRide.NORMAL));
        Assertions.assertEquals(5, fare, 0.0);
    }

    @Test
    public void givenMultipleRides_ShouldReturnTotalSummary() {
        Ride[] ride = {new Ride(2.0, 5, CabRide.NORMAL),
                new Ride(0.1, 1, CabRide.PREMIUM),
        };
        InvoiceSummary summary = invoiceService.calculateFare(ride);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }

    @Test
    public void givenUserIDOfRides_ShouldReturnInvoiceService() {
        String userId = "11";
        Ride[] rides = {new Ride(2.0, 5, CabRide.NORMAL),
                        new Ride(0.1, 1, CabRide.PREMIUM),
        };
//        Map<String, ArrayList<Ride>> list = new HashMap<>();
//        ArrayList<Ride> rideList = new ArrayList<>(Arrays.asList(rides));
//        list.put(userId,rideList);
//        list.get(userId).toArray(new Ride[0]);
//        list.get(userId).toArray(new Ride[0]);

//        RideRepository rideRepository = new RideRepository();
//        invoiceService.setRideRepository(rideRepository);
        InvoiceSummary summary = new InvoiceSummary(2, 45.0);
        when(invoiceService.addRides(userId,rides)).thenReturn(summary);
        invoiceService.addRides(userId,rides);
//        when(rideRepository.getRides(userId)).thenReturn(rides);
//        when(invoiceService.getInvoiceSummary(userId)).thenReturn(new InvoiceSummary(2, 45.0));
//        InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
        Assertions.assertEquals(expectedInvoiceSummary.getTotalFare(), summary.getTotalFare());
    }

    @Test
    public void givenNormalRide_ShouldReturnInvoiceService() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceService.calculateFare(new Ride(distance, time, CabRide.NORMAL));
        Assertions.assertEquals(25, fare, 0.0);
    }

    @Test
    public void givenPremimumRide_ShouldReturnInvoiceService() {
        double distance = 2.0;
        int time = 5;
        double fare = invoiceService.calculateFare(new Ride(distance, time, CabRide.PREMIUM));
        Assertions.assertEquals(40, fare, 0.0);
    }

    @Test
    public void givenMultipleRidesNormalAndPremimum_ShouldReturnTotalSummary() {
        Ride[] ride = {new Ride(2.0, 5, CabRide.NORMAL),
                new Ride(0.1, 1, CabRide.PREMIUM),
        };
        InvoiceSummary summary = invoiceService.calculateFare(ride);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
    }

}
