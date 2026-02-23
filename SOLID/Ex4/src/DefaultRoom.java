public class DefaultRoom implements Room {
  private final double basePrice = 16000.0;

  @Override
  public double getBasePrice() {
    return this.basePrice;
  }
}
