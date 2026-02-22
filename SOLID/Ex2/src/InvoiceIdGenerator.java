public class InvoiceIdGenerator {
  private static int invoiceSeq;

  public static String getNextInvoiceId() {
    String invId = "INV-" + (++invoiceSeq);
    return invId;
  }
}
