public class Q4 {
    public static void main(String[] args) {
        String storeId = "9";
        int id = Integer.parseInt(storeId);

        String padded = String.format("%04d", id);

        System.out.println(padded); // Output: 0009
    }
}
