import java.sql.*;

public class CreditTransfer {

    public static boolean transferCredits(int fromStudentId, int toStudentId, int credits) {
        String url = "jdbc:mysql://localhost:3306/jdbcdemo";
        String user = "root";
        String password = "LEYBs5x4";

        Connection conn = null;
        PreparedStatement deductStmt = null;
        PreparedStatement addStmt = null;

        try {
            conn = DriverManager.getConnection(url, user, password);
            conn.setAutoCommit(false);

            deductStmt = conn.prepareStatement("UPDATE students SET credits = credits - ? WHERE id = ?");
            deductStmt.setInt(1, credits);
            deductStmt.setInt(2, fromStudentId);
            deductStmt.executeUpdate();

            addStmt = conn.prepareStatement("UPDATE students SET credits = credits + ? WHERE id = ?");
            addStmt.setInt(1, credits);
            addStmt.setInt(2, toStudentId);
            addStmt.executeUpdate();

            conn.commit();
            return true;
        } catch (SQLException e) {
            if (conn != null) try { conn.rollback(); } catch (SQLException ex) {}
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (deductStmt != null) deductStmt.close();
                if (addStmt != null) addStmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
