import java.util.*;
import java.util.stream.Collectors;

public class FilterStartWithA {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Amy", "Babun", "Ankit", "Ram");

        List<String> result = names.stream()
                                   .filter(name -> name.startsWith("A"))
                                   .collect(Collectors.toList());

        System.out.println(result); 
    }
}
