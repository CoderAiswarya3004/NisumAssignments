@FunctionalInterface
interface MathOperation {
    int operate(int a, int b);
}

public class MathLambdaDemo {
    public static void main(String[] args) {
        MathOperation add = (a, b) -> a + b;
        MathOperation subtract = (a, b) -> a - b;
        MathOperation multiply = (a, b) -> a * b;

        System.out.println("Add: " + add.operate(5, 3));
        System.out.println("Subtract: " + subtract.operate(5, 3));
        System.out.println("Multiply: " + multiply.operate(5, 3));
    }
}
