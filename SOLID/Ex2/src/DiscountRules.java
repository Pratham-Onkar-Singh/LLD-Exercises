public interface DiscountRules {
    double discountAmount(double subtotal, int distinctLines);
}
