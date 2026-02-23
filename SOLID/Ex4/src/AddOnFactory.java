import java.util.List;

public class AddOnFactory {
    public static List<AddOnService> create(List<AddOn> addOns) {
        return addOns.stream()
                .map(AddOnFactory::createOne)
                .toList();
    }

    private static AddOnService createOne(AddOn addOn) {
        return switch (addOn) {
            case LAUNDRY -> new LaundryAddOn();
            case MESS -> new MessAddOn();
            case GYM -> new GymAddOn();
        };
    }
}
