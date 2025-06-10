import java.util.Scanner;
import java.util.Stack;

public class BrowserTracker {

    static Stack<String> backStack = new Stack<>();
    static String activePage = "Home";

    static void openPage(String newUrl) {
        backStack.push(activePage);
        activePage = newUrl;
        System.out.println("Now viewing: " + activePage);
    }

    static void backNavigation() {
        if (!backStack.isEmpty()) {
            activePage = backStack.pop();
            System.out.println("Returned to: " + activePage);
        } else {
            System.out.println("No previous pages to go back to.");
        }
    }

    static void currentView() {
        System.out.println("You are on: " + activePage);
    }

    static void showVisitedPages() {
        if (backStack.isEmpty()) {
            System.out.println("No history available.");
        } else {
            System.out.println("Visited Pages:");
            for (int i = backStack.size() - 1; i >= 0; i--) {
                System.out.println(backStack.get(i));
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int action;

        do {
            System.out.println("\n--- Browser Menu ---");
            System.out.println("1. Visit New Page");
            System.out.println("2. Back");
            System.out.println("3. Current Page");
            System.out.println("4. Show History");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            action = input.nextInt();
            input.nextLine();

            switch (action) {
                case 1:
                    System.out.print("Enter page URL: ");
                    String page = input.nextLine();
                    openPage(page);
                    break;
                case 2:
                    backNavigation();
                    break;
                case 3:
                    currentView();
                    break;
                case 4:
                    showVisitedPages();
                    break;
                case 5:
                    System.out.println("Session ended.");
                    break;
                default:
                    System.out.println("Invalid input. Try 1–5.");
            }

        } while (action != 5);

        input.close();
    }
}
