public class TransportBookingService {
    private final IDistanceCalculator distanceCalculator;
    private final IDriverAllocator driverAllocator;
    private final IPaymentGateway paymentGateway;
    private final IPricingStrategy pricingStrategy;

    public TransportBookingService(
            IDistanceCalculator distanceCalculator,
            IDriverAllocator driverAllocator,
            IPaymentGateway paymentGateway,
            IPricingStrategy pricingStrategy) {
        this.distanceCalculator = distanceCalculator;
        this.driverAllocator = driverAllocator;
        this.paymentGateway = paymentGateway;
        this.pricingStrategy = pricingStrategy;
    }

    public void book(TripRequest req) {
        double km = distanceCalculator.km(req.from, req.to);
        System.out.println("DistanceKm=" + km);

        String driver = driverAllocator.allocate(req.studentId);
        System.out.println("Driver=" + driver);

        double fare = pricingStrategy.calculateFare(km);

        String txn = paymentGateway.charge(req.studentId, fare);
        System.out.println("Payment=PAID txn=" + txn);

        BookingReceipt r = new BookingReceipt("R-501", fare);
        System.out.println("RECEIPT: " + r.id + " | fare=" + String.format("%.2f", r.fare));
    }
}
