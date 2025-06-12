//Insert Operation
public static boolean insertStudent(int id, String name, int age) {
    String query = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, id);
        stmt.setString(2, name);
        stmt.setInt(3, age);
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

//Update Operation
public static boolean updateStudent(int id, String name, int age) {
    String query = "UPDATE students SET name = ?, age = ? WHERE id = ?";
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setString(1, name);
        stmt.setInt(2, age);
        stmt.setInt(3, id);
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

// Delete Operation
public static boolean deleteStudent(int id) {
    String query = "DELETE FROM students WHERE id = ?";
    try (Connection conn = getConnection();
         PreparedStatement stmt = conn.prepareStatement(query)) {
        stmt.setInt(1, id);
        return stmt.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}
