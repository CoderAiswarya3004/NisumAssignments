import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class FilterWithPredicate {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Ram", "Pavan", "Jaddu", "Chandu");

        Predicate<String> startsWithJ = name -> name.startsWith("J");

        List<String> filtered = names.stream()
                                     .filter(startsWithJ)
                                     .collect(Collectors.toList());

        System.out.println(filtered); 
    }
}
