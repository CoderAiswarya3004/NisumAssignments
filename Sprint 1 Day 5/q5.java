Q.5
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentNameUpdater {

    // Establish a connection to the database
    public static Connection connectToDatabase() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/jdbcdemo";
        String username = "root";
        String pwd = "LEYBs5x4";

        try {
            Connection conn = DriverManager.getConnection(jdbcUrl, username, pwd);
            System.out.println("Database connection successful.");
            return conn;
        } catch (SQLException ex) {
            System.out.println("Failed to connect: " + ex.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Connection conn = connectToDatabase();

        if (conn != null) {
            String sql = "UPDATE students SET name = ? WHERE id = ?";

            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setString(1, "Jane Smith");
                ps.setInt(2, 1);

                int updatedCount = ps.executeUpdate();

                if (updatedCount > 0) {
                    System.out.println("Student's name updated successfully.");
                } else {
                    System.out.println("No matching student found for the provided ID.");
                }

            } catch (SQLException e) {
                System.out.println("Update failed: " + e.getMessage());
            } finally {
                try {
                    conn.close();
                    System.out.println("Connection closed.");
                } catch (SQLException e) {
                    System.out.println("Error closing connection: " + e.getMessage());
                }
            }
        }
    }
}
