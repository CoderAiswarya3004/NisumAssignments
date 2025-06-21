import java.util.*;
import java.util.function.Predicate;

public class RemoveEvenNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(2, 3, 4, 5, 6, 7));
        Predicate<Integer> isEven = n -> n % 2 == 0;

        numbers.removeIf(isEven);

        System.out.println(numbers); 
    }
}
