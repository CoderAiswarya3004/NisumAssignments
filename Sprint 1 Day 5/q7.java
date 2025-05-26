import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SearchStudentRecords {

    // Establishes connection to the database
    private static Connection connectToDatabase() {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String pass = "LEYBs5x4";

        try {
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.err.println("Failed to connect to DB: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the initial letters of the student's name: ");
        String namePrefix = scanner.nextLine();

        try (Connection connection = connectToDatabase()) {
            if (connection == null) {
                System.out.println("Database connection not established. Exiting.");
                return;
            }

            String query = "SELECT id, name, age FROM students WHERE name LIKE ?";
            try (PreparedStatement pstmt = connection.prepareStatement(query)) {
                pstmt.setString(1, namePrefix + "%");

                try (ResultSet rs = pstmt.executeQuery()) {
                    boolean found = false;

                    while (rs.next()) {
                        int id = rs.getInt("id");
                        String name = rs.getString("name");
                        int age = rs.getInt("age");

                        System.out.printf("ID: %d | Name: %s | Age: %d%n", id, name, age);
                        found = true;
                    }

                    if (!found) {
                        System.out.println("No students found starting with \"" + namePrefix + "\".");
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Query error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
