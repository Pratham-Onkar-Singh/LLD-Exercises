import java.util.*;

public class CafeteriaSystem {
    private final InvoiceStore store;
    private final TaxRules taxRules;
    private final DiscountRules discountRules;
    Map<String, MenuItem> menu;

    public CafeteriaSystem(InvoiceStore store, TaxRules taxRules, DiscountRules discountRules, Map<String, MenuItem> menu) {
        this.store = store;
        this.taxRules = taxRules;
        this.discountRules = discountRules;
        this.menu = menu;
    }
    
    public void checkout(List<OrderLine> lines) {
        // Get order subtotal amount
        double subtotal = OrderManagment.getSubtotal(lines, menu);
        
        // Tax handling
        double taxPct = taxRules.taxPercent();
        double tax = taxRules.getTaxAmount(subtotal);
        
        // Discount handling
        double discount = discountRules.discountAmount(subtotal, lines.size());
        
        // Calculate total
        double total = OrderManagment.getTotal(subtotal, tax, discount);

        // Get invoice Id and Specifying invoice format
        String invId = InvoiceIdGenerator.getNextInvoiceId();
        String invoice = InvoiceFormatter.getInvoice(invId, lines, menu, subtotal, taxPct, tax, discount, total);
        
        // Print invoice
        OutputService.printInvoice(invoice);
        
        // Saving to DB
        store.save(invId, invoice);

        // Print success message
        OutputService.printSuccessfullInvoiceSave(invId, store.countLines(invId));
    }
}
