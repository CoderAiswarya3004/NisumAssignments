import java.util.function.Supplier;

public class RandomSupplier {
    public static void main(String[] args) {
        Supplier<Double> randomSupplier = () -> Math.random();

        for (int i = 0; i < 5; i++) {
            System.out.println("Random #" + (i + 1) + ": " + randomSupplier.get());
        }
    }
}
