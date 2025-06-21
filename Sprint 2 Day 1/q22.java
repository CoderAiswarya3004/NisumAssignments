import java.util.*;
import java.util.function.Consumer;

public class PrintStrings {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Aman", "Bobby", "Chitra");

        Consumer<String> printer = s -> System.out.println(s);

        names.forEach(printer);
    }
}
