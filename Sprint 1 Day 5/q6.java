Q.6

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentRecordDeletion {

    // Method to establish DB connection
    public static Connection createConnection() {
        String dbUrl = "jdbc:mysql://localhost:3306/jdbcdemo";
        String dbUser = "root";
        String dbPassword = "LEYBs5x4";

        try {
            Connection conn = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            System.out.println("Successfully connected to the database.");
            return conn;
        } catch (SQLException e) {
            System.err.println("Unable to connect to database: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Please enter the Student ID to remove: ");
        int studentId = input.nextInt();

        Connection conn = createConnection();

        if (conn != null) {
            String deleteSQL = "DELETE FROM students WHERE id = ?";

            try (PreparedStatement pstmt = conn.prepareStatement(deleteSQL)) {
                pstmt.setInt(1, studentId);

                int affectedRows = pstmt.executeUpdate();

                if (affectedRows > 0) {
                    System.out.println("Student record has been successfully deleted.");
                } else {
                    System.out.println("No student found matching the provided ID.");
                }

            } catch (SQLException ex) {
                System.err.println("Deletion error: " + ex.getMessage());
            } finally {
                try {
                    conn.close();
                    System.out.println("Database connection closed.");
                } catch (SQLException e) {
                    System.err.println("Failed to close connection: " + e.getMessage());
                }
            }
        }

        input.close();
    }
}
