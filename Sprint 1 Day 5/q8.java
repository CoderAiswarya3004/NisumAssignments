import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDemo {

    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/jdbcdemo";
        String dbUser = "root";
        String dbPassword = "LEYBs5x4";

        Connection connection = null;

        try {
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
            connection.setAutoCommit(false);  // Begin transaction

            String addStudentSQL = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
            try (PreparedStatement addStudentStmt = connection.prepareStatement(addStudentSQL)) {
                addStudentStmt.setInt(1, 101);
                addStudentStmt.setString(2, "Arjun");
                addStudentStmt.setInt(3, 22);
                addStudentStmt.executeUpdate();
            }

            String addLogSQL = "INSERT INTO logs (student_id, action) VALUES (?, ?)";
            try (PreparedStatement addLogStmt = connection.prepareStatement(addLogSQL)) {
                addLogStmt.setInt(1, 101);
                addLogStmt.setString(2, "Student Added");
                addLogStmt.executeUpdate();
            }

            connection.commit();  // Commit transaction
            System.out.println("Transaction completed: Student and log records inserted.");

        } catch (SQLException ex) {
            System.err.println("Transaction error: " + ex.getMessage());
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Transaction rolled back due to error.");
                } catch (SQLException rollbackEx) {
                    System.err.println("Rollback error: " + rollbackEx.getMessage());
                }
            }
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException closeEx) {
                    System.err.println("Error closing connection: " + closeEx.getMessage());
                }
            }
        }
    }
}
