@FunctionalInterface
interface Operation {
    int apply(int a, int b);
}

public class FlexibleOperation {
    public static void main(String[] args) {
        performOperation((x, y) -> x + y); // Add
        performOperation((x, y) -> x * y); // Multiply
    }

    static void performOperation(Operation op) {
        int result = op.apply(5, 3);
        System.out.println("Result: " + result);
    }
}
