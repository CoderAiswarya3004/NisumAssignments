import java.util.Scanner;
import java.util.TreeSet;

class Staff implements Comparable<Staff> {
    int empId;
    String empName;
    String dept;
    double income;

    public Staff(int empId, String empName, String dept, double income) {
        this.empId = empId;
        this.empName = empName;
        this.dept = dept;
        this.income = income;
    }

    public int compareTo(Staff s) {
        return this.empName.compareToIgnoreCase(s.empName);
    }

    public String toString() {
        return "ID: " + empId + ", Name: " + empName + ", Dept: " + dept + ", Salary: " + income;
    }
}

public class EmployeeManager {

    static TreeSet<Staff> teamList = new TreeSet<>();

    static void addStaff(int id, String name, String dept, double pay) {
        Staff entry = new Staff(id, name, dept, pay);
        if (teamList.add(entry)) {
            System.out.println("Employee added.");
        } else {
            System.out.println("Employee not added (duplicate name).");
        }
    }

    static void showAllStaff() {
        if (teamList.isEmpty()) {
            System.out.println("No employee data available.");
        } else {
            System.out.println("Employee List (Alphabetically):");
            for (Staff s : teamList) {
                System.out.println(s);
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option;

        do {
            System.out.println("\n--- Employee Menu ---");
            System.out.println("1. Add New Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Exit");
            System.out.print("Your choice: ");
            option = input.nextInt();
            input.nextLine(); // clear newline

            switch (option) {
                case 1:
                    System.out.print("ID: ");
                    int id = input.nextInt();
                    input.nextLine();
                    System.out.print("Name: ");
                    String name = input.nextLine();
                    System.out.print("Department: ");
                    String dept = input.nextLine();
                    System.out.print("Salary: ");
                    double salary = input.nextDouble();
                    addStaff(id, name, dept, salary);
                    break;

                case 2:
                    showAllStaff();
                    break;

                case 3:
                    System.out.println("Goodbye.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (option != 3);

        input.close();
    }
}
