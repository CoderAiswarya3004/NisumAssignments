import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ProductSearch {

    public static void searchProducts(String category, Double minPrice, Double maxPrice) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/your_database", "your_username", "your_password");

            StringBuilder query = new StringBuilder("SELECT * FROM products WHERE 1=1");
            
            if (category != null && !category.isEmpty()) {
                query.append(" AND category = ?");
            }
            if (minPrice != null) {
                query.append(" AND price >= ?");
            }
            if (maxPrice != null) {
                query.append(" AND price <= ?");
            }

            PreparedStatement pstmt = conn.prepareStatement(query.toString());

            int paramIndex = 1;
            if (category != null && !category.isEmpty()) {
                pstmt.setString(paramIndex++, category);
            }
            if (minPrice != null) {
                pstmt.setDouble(paramIndex++, minPrice);
            }
            if (maxPrice != null) {
                pstmt.setDouble(paramIndex++, maxPrice);
            }

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " - " +
                        rs.getString("name") + " - " +
                        rs.getString("category") + " - " +
                        rs.getDouble("price"));
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
