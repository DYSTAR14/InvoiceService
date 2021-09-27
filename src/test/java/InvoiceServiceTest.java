import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InvoiceServiceTest {
    InvoiceService invoiceService = null;

    @BeforeEach
    public void setUp() {
        invoiceService = new InvoiceService();
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
        Ride[] ride = {new Ride(2.0, 5, CabRide.NORMAL),
                        new Ride(0.1, 1, CabRide.PREMIUM),
        };
        RideRepository rideRepository = new RideRepository();
        invoiceService.setRideRepository(rideRepository);
        invoiceService.addRides(userId,ride);
        InvoiceSummary summary = invoiceService.getInvoiceSummary(userId);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 45.0);
        Assertions.assertEquals(expectedInvoiceSummary, summary);
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
