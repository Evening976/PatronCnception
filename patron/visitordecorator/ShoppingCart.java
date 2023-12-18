package patron.visitordecorator;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    List<Item> items = new ArrayList<>();

    public List<Item> items() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }
}
