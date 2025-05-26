import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentRecordsFetcher {

    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/jdbcdemo";
        String dbUser = "root";
        String dbPassword = "LEYBs5x4";

        try (
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students")
        ) {
            while (resultSet.next()) {
                int studentId = resultSet.getInt("id");
                String studentName = resultSet.getString("name");
                int studentAge = resultSet.getInt("age");

                System.out.println(String.format("ID: %d | Name: %s | Age: %d", studentId, studentName, studentAge));
            }
        } catch (SQLException ex) {
            System.err.println("Encountered an SQL exception:");
            System.err.printf("SQLState: %s%nErrorCode: %d%nMessage: %s%n",
                              ex.getSQLState(), ex.getErrorCode(), ex.getMessage());
        }
    }}
