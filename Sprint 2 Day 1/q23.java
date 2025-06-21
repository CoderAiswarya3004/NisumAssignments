import java.util.*;
import java.util.function.Consumer;

public class DoubleNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 6, 8);

        Consumer<Integer> doubler = n -> System.out.println(n * 2);

        numbers.forEach(doubler);
    }
}
