public class TripleRoom implements Room {
  private final double basePrice = 12000.0;
  
  @Override
  public double getBasePrice() {
    return this.basePrice;
  }
}
