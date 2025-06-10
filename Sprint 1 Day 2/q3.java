import java.util.HashSet;
import java.util.Scanner;

public class EmailTracker {

    static HashSet<String> storedEmails = new HashSet<>();

    static void registerEmail(String email) {
        boolean isNew = storedEmails.add(email);
        if (isNew) {
            System.out.println("Email saved.");
        } else {
            System.out.println("This email already exists in the system.");
        }
    }

    static void listEmails() {
        if (storedEmails.isEmpty()) {
            System.out.println("No emails have been registered yet.");
        } else {
            System.out.println("Registered Email Addresses:");
            for (String e : storedEmails) {
                System.out.println("- " + e);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n=== Email Management ===");
            System.out.println("1. Add Email");
            System.out.println("2. Display All Emails");
            System.out.println("3. Exit");
            System.out.print("Select an option: ");
            option = sc.nextInt();
            sc.nextLine(); // clear input

            switch (option) {
                case 1:
                    System.out.print("Enter email: ");
                    String input = sc.nextLine();
                    registerEmail(input);
                    break;
                case 2:
                    listEmails();
                    break;
                case 3:
                    System.out.println("Application terminated.");
                    break;
                default:
                    System.out.println("Invalid option. Please choose 1, 2, or 3.");
            }
        } while (option != 3);

        sc.close();
    }
}
