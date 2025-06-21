import java.util.function.Function;

public class UpperCaseRef {
    public static void main(String[] args) {
        Function<String, String> toUpper = String::toUpperCase;

        System.out.println(toUpper.apply("hello")); 
    }
}
