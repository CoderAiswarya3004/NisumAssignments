public Student getStudentById(int studentId) {
    Student student = null;
    String sql = "SELECT * FROM students WHERE id = ?";
    
    try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        
        pstmt.setInt(1, studentId);
        ResultSet rs = pstmt.executeQuery();
        
        if (rs.next()) {
            student = new Student();
            student.setId(rs.getInt("id"));
            student.setName(rs.getString("name"));
            student.setEmail(rs.getString("email"));
            student.setAge(rs.getInt("age"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return student;
}
