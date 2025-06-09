class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double add(int a, double b) {
        return a + b;
    }
}

public class MethodOverloadingDemo {
    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("Sum of 2 and 3: " + calc.add(2, 3));
        System.out.println("Sum of 1, 2 and 3: " + calc.add(1, 2, 3));
        System.out.println("Sum of 2.5 and 3.5: " + calc.add(2.5, 3.5));
        System.out.println("Sum of 4 and 2.5: " + calc.add(4, 2.5));
    }
}
