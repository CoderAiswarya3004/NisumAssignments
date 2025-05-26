Q.1.
 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCDemo {

    public static Connection connectToDatabase() {
        String dbUrl = "jdbc:mysql://localhost:3306/jdbcdemo";
        String username = "root";
        String password = "LEYBs5x4";

        try {
            Connection connection = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Successfully connected to the database.");
            return connection;
        } catch (SQLException e) {
            System.out.println("Database connection failed: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Connection conn = connectToDatabase();

        if (conn != null) {
            try {
                conn.close();
                System.out.println("Connection closed properly.");
            } catch (SQLException e) {
                System.out.println("Error while closing the connection: " + e.getMessage());
            }
        }
    }
} Explain this soln
