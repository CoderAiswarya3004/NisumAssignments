import java.util.HashMap;
import java.util.Scanner;

public class InventoryApp {

    static HashMap<String, Integer> stock = new HashMap<>();

    static void addItem(String item, int quantity) {
        if (stock.containsKey(item)) {
            System.out.println("Item already in stock. Try updating instead.");
        } else {
            stock.put(item, quantity);
            System.out.println("Item added.");
        }
    }

    static void updateItem(String item, int quantity) {
        if (stock.containsKey(item)) {
            stock.put(item, quantity);
            System.out.println("Quantity updated.");
        } else {
            System.out.println("Item not found in inventory.");
        }
    }

    static void deleteItem(String item) {
        if (stock.remove(item) != null) {
            System.out.println("Item removed from inventory.");
        } else {
            System.out.println("Item does not exist.");
        }
    }

    static void checkItem(String item) {
        if (stock.containsKey(item)) {
            System.out.println(item + " is in stock. Quantity: " + stock.get(item));
        } else {
            System.out.println(item + " is not available.");
        }
    }

    static void showAllItems() {
        if (stock.isEmpty()) {
            System.out.println("Inventory is currently empty.");
        } else {
            System.out.println("Available Items:");
            for (String key : stock.keySet()) {
                System.out.println(key + " → Quantity: " + stock.get(key));
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int selection;

        do {
            System.out.println("\n== Inventory System Menu ==");
            System.out.println("1. Add Item");
            System.out.println("2. Update Quantity");
            System.out.println("3. Delete Item");
            System.out.println("4. Check Stock");
            System.out.println("5. View Inventory");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            selection = input.nextInt();
            input.nextLine(); // clear buffer

            switch (selection) {
                case 1:
                    System.out.print("Item Name: ");
                    String item = input.nextLine();
                    System.out.print("Quantity: ");
                    int qty = input.nextInt();
                    addItem(item, qty);
                    break;

                case 2:
                    System.out.print("Item to update: ");
                    String updateItem = input.nextLine();
                    System.out.print("New Quantity: ");
                    int newQty = input.nextInt();
                    updateItem(updateItem, newQty);
                    break;

                case 3:
                    System.out.print("Item to delete: ");
                    String delItem = input.nextLine();
                    deleteItem(delItem);
                    break;

                case 4:
                    System.out.print("Check item: ");
                    String chkItem = input.nextLine();
                    checkItem(chkItem);
                    break;

                case 5:
                    showAllItems();
                    break;

                case 6:
                    System.out.println("System closed.");
                    break;

                default:
                    System.out.println("Invalid input. Please choose between 1–6.");
            }

        } while (selection != 6);

        input.close();
    }
}
