public class MessAddOn implements AddOnService {
  private final double price = 1000.0;

  @Override
  public double getPrice() {
    return this.price;
  }
}
