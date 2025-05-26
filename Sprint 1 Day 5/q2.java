Q.2.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStudent {

    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/jdbcdemo";
        String username = "root";
        String password = "LEYBs5x4";

        Connection conn = null;
        Statement stmt = null;

        try {
            conn = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Connected to the database.");

            stmt = conn.createStatement();
            String insertQuery = "INSERT INTO students (id, name, age) VALUES (1, 'Alice', 20)";
            int result = stmt.executeUpdate(insertQuery);

            if (result > 0) {
                System.out.println("Student added successfully.");
            } else {
                System.out.println("Insert operation failed.");
            }

        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
    }
}
