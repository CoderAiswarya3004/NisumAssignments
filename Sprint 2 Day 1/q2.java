@FunctionalInterface
interface Calculator {
    int operate(int a, int b);
}

public class CustomFunctionalInterfaceDemo {
    public static void main(String[] args) {
        Calculator add = (a, b) -> a + b;
        System.out.println("Sum: " + add.operate(5, 3));
    }
}
