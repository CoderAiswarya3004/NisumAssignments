import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoredProcDemo {

    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/jdbcdemo";
        String username = "root";
        String pwd = "LEYBs5x4";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, pwd)) {

            String procedureCall = "{CALL getStudentById(?)}";
            try (CallableStatement callableStmt = connection.prepareCall(procedureCall)) {

                callableStmt.setInt(1, 101);  // Set procedure input parameter

                try (ResultSet resultSet = callableStmt.executeQuery()) {
                    while (resultSet.next()) {
                        int studentId = resultSet.getInt("id");
                        String studentName = resultSet.getString("name");
                        int studentAge = resultSet.getInt("age");

                        System.out.printf("ID: %d, Name: %s, Age: %d%n", studentId, studentName, studentAge);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Stored procedure execution failed: " + e.getMessage());
        }
    }
}
