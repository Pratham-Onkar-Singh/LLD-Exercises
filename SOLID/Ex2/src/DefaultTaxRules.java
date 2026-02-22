public class DefaultTaxRules implements TaxRules {
    @Override
    public double taxPercent() {
        return 8.0;
    }

    @Override
    public double getTaxAmount(double subtotal) {
        return subtotal * (taxPercent() / 100);
    }
}
