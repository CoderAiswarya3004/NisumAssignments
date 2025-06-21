import java.util.*;
import java.util.function.Consumer;

public class UppercasePrinter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Samita", "Raj", "johnny");

        Consumer<List<String>> printUpper = list -> 
            list.forEach(item -> System.out.println(item.toUpperCase()));

        printUpper.accept(names);
    }
}
