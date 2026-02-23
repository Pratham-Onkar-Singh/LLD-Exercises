import java.util.Random;

public class BookingIdGenerator {
  public static String getBookingId() {
    String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
    return bookingId;
  }
}
