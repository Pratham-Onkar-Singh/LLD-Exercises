public interface TaxRules {
    double taxPercent();
    double getTaxAmount(double subtotal);
}
