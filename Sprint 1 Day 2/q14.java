import java.util.*;

class Item {
    String itemName;
    String type;
    double cost;

    public Item(String itemName, String type, double cost) {
        this.itemName = itemName;
        this.type = type;
        this.cost = cost;
    }

    public String toString() {
        return itemName + " → " + type + " → $" + cost;
    }
}

public class ProductSorter {
    public static void main(String[] args) {
        List<Item> inventory = new ArrayList<>();

        inventory.add(new Item("Desk", "Furniture", 150.00));
        inventory.add(new Item("Smartphone", "Electronics", 899.99));
        inventory.add(new Item("Orange", "Fruits", 0.90));
        inventory.add(new Item("Television", "Electronics", 500.00));
        inventory.add(new Item("Mango", "Fruits", 1.50));

        inventory.sort(Comparator
                .comparing((Item i) -> i.type)
                .thenComparing(i -> i.cost));

        for (Item i : inventory) {
            System.out.println(i);
        }
    }
}
