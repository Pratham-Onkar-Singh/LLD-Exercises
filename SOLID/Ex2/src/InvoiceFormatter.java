import java.util.List;
import java.util.Map;

public class InvoiceFormatter {
    private static StringBuilder initiate(String invId) {
        StringBuilder out = new StringBuilder();
        out.append("Invoice# ").append(invId).append("\n");

        return out;
    }

    private static String addItems(List<OrderLine> lines, Map<String, MenuItem> menu) {
        StringBuilder items = new StringBuilder();
        for (OrderLine l : lines) {
            MenuItem item = menu.get(l.itemId);
            double lineTotal = item.price * l.qty;
            items.append(String.format("- %s x%d = %.2f\n", item.name, l.qty, lineTotal));
        }
        return items.toString();
    }

    private static String getInvoiceSummary(double subtotal, double taxPct, double tax, double discount, double total) {
        StringBuilder invoiceSummary = new StringBuilder();
        invoiceSummary.append(String.format("Subtotal: %.2f\n", subtotal));
        invoiceSummary.append(String.format("Tax(%.0f%%): %.2f\n", taxPct, tax));
        invoiceSummary.append(String.format("Discount: -%.2f\n", discount));
        invoiceSummary.append(String.format("TOTAL: %.2f\n", total));

        return invoiceSummary.toString();
    }     

    public static String getInvoice(String invId, List<OrderLine> lines, Map<String, MenuItem> menu, double subtotal, double taxPct, double tax, double discount, double total) {
        StringBuilder invoice = initiate(invId);
        String items = addItems(lines, menu);
        invoice.append(items);

        String invoiceSummary = getInvoiceSummary(subtotal, taxPct, tax, discount, total);
        invoice.append(invoiceSummary);

        return invoice.toString();
    }
}
