import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Cafeteria Billing ===");

        MenuRegistry.addToMenu(new MenuItem("M1", "Veg Thali", 80.00));
        MenuRegistry.addToMenu(new MenuItem("C1", "Coffee", 30.00));
        MenuRegistry.addToMenu(new MenuItem("S1", "Sandwich", 60.00));
        
        List<OrderLine> order = Arrays.asList(
            new OrderLine("M1", 2),
            new OrderLine("C1", 1)
        );
        
        FileStore store = new FileStore();
        TaxRules taxRules = new StudentTaxRules();
        DiscountRules discountRules = new StudentDiscountRules();
        Map<String, MenuItem> menu = MenuRegistry.getMenu();
        CafeteriaSystem sys = new CafeteriaSystem(store, taxRules, discountRules, menu);
        sys.checkout(order);
    }
}
