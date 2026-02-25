import java.util.List;
import java.util.Map;

public class OrderManagment {
  
  public static double getSubtotal(List<OrderLine> lines, Map<String, MenuItem> menu) {
    double subtotal = 0.0;
    for (OrderLine l : lines) {
        MenuItem item = menu.get(l.itemId);
        double lineTotal = item.price * l.qty;
        subtotal += lineTotal;
    }

    return subtotal;
  }

  public static double getTotal(double subtotal, double tax, double discount) {
    return subtotal + tax - discount;
  }
}
