import java.sql.*;

public class CourseDetailsFetcher {

    public static void getCoursesByStudentId(int studentId) {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String password = "LEYBs5x4";

        try (
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(
                "SELECT c.course_name, c.instructor, e.grade " +
                "FROM courses c " +
                "JOIN enrollments e ON c.id = e.course_id " +
                "JOIN students s ON s.id = e.student_id " +
                "WHERE s.id = ?"
            )
        ) {
            stmt.setInt(1, studentId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                System.out.println("Course: " + rs.getString("course_name") +
                                   ", Instructor: " + rs.getString("instructor") +
                                   ", Grade: " + rs.getString("grade"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
