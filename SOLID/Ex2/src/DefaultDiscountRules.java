public class DefaultDiscountRules implements DiscountRules {

  @Override
  public double discountAmount(double subtotal, int distinctLines) {
    return 0.0;
  }
  
}
