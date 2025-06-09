import java.util.ArrayList;
import java.util.Scanner;

class Record {
    int studentId;
    String studentName;
    double studentMarks;

    Record(int studentId, String studentName, double studentMarks) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentMarks = studentMarks;
    }

    public String toString() {
        return "ID: " + studentId + ", Name: " + studentName + ", Grade: " + studentMarks;
    }
}

public class StudentManager {
    static ArrayList<Record> records = new ArrayList<>();

    static void insertStudent(int id, String name, double marks) {
        records.add(new Record(id, name, marks));
        System.out.println("Student added successfully.");
    }

    static void removeStudent(int id) {
        boolean removed = records.removeIf(r -> r.studentId == id);
        if (removed) {
            System.out.println("Student record removed.");
        } else {
            System.out.println("No record found with ID: " + id);
        }
    }

    static void searchStudent(int id) {
        for (Record r : records) {
            if (r.studentId == id) {
                System.out.println("Student located: " + r);
                return;
            }
        }
        System.out.println("Student ID " + id + " not found.");
    }

    static void displayAll() {
        if (records.isEmpty()) {
            System.out.println("No student data available.");
        } else {
            System.out.println("Student Records:");
            for (Record r : records) {
                System.out.println(r);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int selection;

        do {
            System.out.println("\n==== Student Database Menu ====");
            System.out.println("1. Add Student");
            System.out.println("2. Delete Student");
            System.out.println("3. Search Student");
            System.out.println("4. Show All Students");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1–5): ");
            selection = sc.nextInt();

            switch (selection) {
                case 1:
                    System.out.print("Enter ID: ");
                    int sid = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Name: ");
                    String sname = sc.nextLine();
                    System.out.print("Enter Grade: ");
                    double marks = sc.nextDouble();
                    insertStudent(sid, sname, marks);
                    break;
                case 2:
                    System.out.print("Enter ID to delete: ");
                    int delId = sc.nextInt();
                    removeStudent(delId);
                    break;
                case 3:
                    System.out.print("Enter ID to search: ");
                    int findId = sc.nextInt();
                    searchStudent(findId);
                    break;
                case 4:
                    displayAll();
                    break;
                case 5:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid input. Please select between 1 and 5.");
            }

        } while (selection != 5);

        sc.close();
    }
}
