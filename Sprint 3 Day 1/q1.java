public class DivideExample {

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Divisor cannot be zero.");
        }
        return a / b;
    }

    public static void main(String[] args) {
        System.out.println("Division with valid input:");
        try {
            int result1 = divide(10, 2);
            System.out.println("10 / 2 = " + result1);
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\nDivision with zero divisor:");
        try {
            int result2 = divide(5, 0);
            System.out.println("5 / 0 = " + result2);
        } catch (ArithmeticException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}
