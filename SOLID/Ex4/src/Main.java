import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Hostel Fee Calculator ===");
        // BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
        BookingRequest req = new BookingRequest(LegacyRoomTypes.DOUBLE, List.of(AddOn.LAUNDRY, AddOn.MESS));
        Room room = RoomFactory.create(req.roomType);
        List<AddOnService> addOns = AddOnFactory.create(req.addOns);
        HostelFeeCalculator calc = new HostelFeeCalculator(new FakeBookingRepo(), room, addOns);
        calc.process(req);
    }
}
