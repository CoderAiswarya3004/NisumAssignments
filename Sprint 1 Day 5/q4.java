import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentInsertion {

    // Method to establish database connection
    public static Connection establishConnection() {
        String dbURL = "jdbc:mysql://localhost:3306/jdbcdemo";
        String dbUser = "root";
        String dbPassword = "LEYBs5x4";

        try {
            Connection connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);
            System.out.println("Successfully connected to the database.");
            return connection;
        } catch (SQLException ex) {
            System.out.println("Failed to connect: " + ex.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Connection conn = establishConnection();

        if (conn != null) {
            String sqlInsert = "INSERT INTO students(id, name, age) VALUES (?, ?, ?)";

            try (PreparedStatement preparedStatement = conn.prepareStatement(sqlInsert)) {

                preparedStatement.setInt(1, 1);
                preparedStatement.setString(2, "John Doe");
                preparedStatement.setInt(3, 22);

                int affectedRows = preparedStatement.executeUpdate();
                System.out.println(affectedRows + " row(s) added to the students table.");

            } catch (SQLException e) {
                System.out.println("Insertion error: " + e.getMessage());
            } finally {
                try {
                    conn.close();
                    System.out.println("Database connection closed.");
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
}
