public class StudentTaxRules implements TaxRules {
    @Override
    public double taxPercent() {
        return 5.0;
    }

    @Override
    public double getTaxAmount(double subtotal) {
        return subtotal * (taxPercent() / 100);
    }
}
