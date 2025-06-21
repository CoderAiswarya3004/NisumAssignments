interface MathUtils {
    static int square(int x) {
        return x * x;
    }
}

public class StaticMethodExample {
    public static void main(String[] args) {
        System.out.println("Square of 5: " + MathUtils.square(5));
    }
}
