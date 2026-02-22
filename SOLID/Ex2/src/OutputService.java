public class OutputService {
  public static void printInvoice(String printableInvoice) {
    System.out.println(printableInvoice);
  }

  public static void printSuccessfullInvoiceSave(String invId, int totalLines) {
    System.out.println("Saved invoice: " + invId + " (lines=" + totalLines + ")");
  } 
}
