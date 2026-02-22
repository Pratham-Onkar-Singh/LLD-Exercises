import java.util.LinkedHashMap;
import java.util.Map;

public class MenuRegistry {
  private static final Map<String, MenuItem> menu = new LinkedHashMap<>();

  public static void addToMenu(MenuItem i) { 
    menu.put(i.id, i);
  }

  public static Map<String, MenuItem> getMenu() {
    return menu;
  }

  public static double getItemPrice(String itemId) {
    MenuItem menuItem = menu.get(itemId);

    return menuItem.price;
  }
}
