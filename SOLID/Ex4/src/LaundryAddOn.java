public class LaundryAddOn implements AddOnService {
  private final double price = 500.0;

  @Override
  public double getPrice() {
    return this.price;
  }
}
