public class DoubleRoom implements Room {
  private final double basePrice = 15000.0;

  @Override
  public double getBasePrice() {
    return this.basePrice;
  }
}
