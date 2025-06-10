import java.util.*;

class Dish {
    String title;
    String details;
    double cost;

    public Dish(String title, String details, double cost) {
        this.title = title;
        this.details = details;
        this.cost = cost;
    }

    public String toString() {
        return title + " - " + details + " (₹" + cost + ")";
    }
}

public class MenuOrganizer {

    static LinkedHashMap<String, LinkedHashMap<String, Dish>> menuBoard = new LinkedHashMap<>();

    static void addDish(String section, String dishName, String description, double price) {
        menuBoard.putIfAbsent(section, new LinkedHashMap<>());
        menuBoard.get(section).put(dishName, new Dish(dishName, description, price));
        System.out.println("Dish added under \"" + section + "\" section.");
    }

    static void updateDish(String section, String dishName, String desc, double rate) {
        if (menuBoard.containsKey(section) && menuBoard.get(section).containsKey(dishName)) {
            menuBoard.get(section).put(dishName, new Dish(dishName, desc, rate));
            System.out.println("Dish details updated.");
        } else {
            System.out.println("Dish not found.");
        }
    }

    static void removeDish(String section, String dishName) {
        if (menuBoard.containsKey(section) && menuBoard.get(section).remove(dishName) != null) {
            System.out.println("Dish \"" + dishName + "\" removed from " + section);
        } else {
            System.out.println("Dish not found.");
        }
    }

    static void showFullBoard() {
        if (menuBoard.isEmpty()) {
            System.out.println("No dishes have been added yet.");
            return;
        }
        System.out.println("\n--- Complete Menu ---");
        for (Map.Entry<String, LinkedHashMap<String, Dish>> cat : menuBoard.entrySet()) {
            System.out.println("\n[" + cat.getKey() + "]");
            for (Dish d : cat.getValue().values()) {
                System.out.println("  " + d);
            }
        }
    }

    static void displayCategory(String section) {
        if (menuBoard.containsKey(section)) {
            System.out.println("\n--- " + section + " Section ---");
            for (Dish d : menuBoard.get(section).values()) {
                System.out.println("  " + d);
            }
        } else {
            System.out.println("Category doesn't exist.");
        }
    }

    static void listSections() {
        if (menuBoard.isEmpty()) {
            System.out.println("No categories yet.");
        } else {
            System.out.println("\nAvailable Categories:");
            for (String key : menuBoard.keySet()) {
                System.out.println("→ " + key);
            }
        }
    }

    static void searchDish(String section, String dishName) {
        if (menuBoard.containsKey(section) && menuBoard.get(section).containsKey(dishName)) {
            System.out.println("Found: " + menuBoard.get(section).get(dishName));
        } else {
            System.out.println("Dish not found in the specified section.");
        }
    }

    static void clearSection(String section) {
        if (menuBoard.containsKey(section)) {
            menuBoard.remove(section);
            System.out.println("Section \"" + section + "\" cleared.");
        } else {
            System.out.println("Section not found.");
        }
    }

    static void resetMenu() {
        menuBoard.clear();
        System.out.println("All menu data has been cleared.");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int action;

        do {
            System.out.println("\n--- Menu Dashboard ---");
            System.out.println("1. Add Dish");
            System.out.println("2. Delete Dish");
            System.out.println("3. Edit Dish");
            System.out.println("4. Show Full Menu");
            System.out.println("5. View Specific Category");
            System.out.println("6. Show All Categories");
            System.out.println("7. Search Dish");
            System.out.println("8. Clear Category");
            System.out.println("9. Clear Menu");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            action = sc.nextInt();
            sc.nextLine();

            switch (action) {
                case 1:
                    System.out.print("Section: ");
                    String sec = sc.nextLine();
                    System.out.print("Dish Name: ");
                    String dish = sc.nextLine();
                    System.out.print("Description: ");
                    String desc = sc.nextLine();
                    System.out.print("Price: ");
                    double cost = sc.nextDouble();
                    addDish(sec, dish, desc, cost);
                    break;

                case 2:
                    System.out.print("Section: ");
                    String delCat = sc.nextLine();
                    System.out.print("Dish to delete: ");
                    String delDish = sc.nextLine();
                    removeDish(delCat, delDish);
                    break;

                case 3:
                    System.out.print("Section: ");
                    String upCat = sc.nextLine();
                    System.out.print("Dish to update: ");
                    String upDish = sc.nextLine();
                    System.out.print("New Description: ");
                    String newDesc = sc.nextLine();
                    System.out.print("New Price: ");
                    double newPrice = sc.nextDouble();
                    updateDish(upCat, upDish, newDesc, newPrice);
                    break;

                case 4:
                    showFullBoard();
                    break;

                case 5:
                    System.out.print("Enter section to view: ");
                    String show = sc.nextLine();
                    displayCategory(show);
                    break;

                case 6:
                    listSections();
                    break;

                case 7:
                    System.out.print("Section: ");
                    String searchCat = sc.nextLine();
                    System.out.print("Dish name: ");
                    String searchDish = sc.nextLine();
                    searchDish(searchCat, searchDish);
                    break;

                case 8:
                    System.out.print("Section to clear: ");
                    String secClear = sc.nextLine();
                    clearSection(secClear);
                    break;

                case 9:
                    resetMenu();
                    break;

                case 10:
                    System.out.println("Thank you. Session ended.");
                    break;

                default:
                    System.out.println("Invalid input.");
            }

        } while (action != 10);

        sc.close();
    }
}
