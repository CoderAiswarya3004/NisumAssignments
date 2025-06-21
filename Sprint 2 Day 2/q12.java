import java.util.*;
import java.util.stream.*;

public class Q12 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("John", "Male", 50000),
            new Employee("Alice", "Female", 60000),
            new Employee("Mike", "Male", 70000),
            new Employee("Lily", "Female", 55000)
        );

        Map<String, String> grouped = employees.stream()
            .collect(Collectors.groupingBy(
                e -> e.gender,
                Collectors.mapping(e -> e.name, Collectors.joining("-"))
            ));

        System.out.println("MALE: [" + grouped.getOrDefault("Male", "") + "]");
        System.out.println("FEMALE: [" + grouped.getOrDefault("Female", "") + "]");
    }
}
