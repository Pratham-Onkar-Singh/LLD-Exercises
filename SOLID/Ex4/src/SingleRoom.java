public class SingleRoom implements Room {
  private final double basePrice = 14000.0;

  @Override
  public double getBasePrice() {
    return this.basePrice;
  }
}
