public class GymAddOn implements AddOnService {
  private final double price = 300.0;

  @Override
  public double getPrice() {
    return this.price;
  }
}
