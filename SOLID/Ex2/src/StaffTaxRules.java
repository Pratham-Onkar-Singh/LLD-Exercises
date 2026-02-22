public class StaffTaxRules implements TaxRules {
    @Override
    public double taxPercent() {
        return 2.0;
    }

    @Override
    public double getTaxAmount(double subtotal) {
        return subtotal * (taxPercent() / 100);
    }
}
