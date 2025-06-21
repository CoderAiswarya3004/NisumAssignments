import java.util.stream.*;

public class Q8 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Ravi", "Patel", "HR"),
            new Employee("Aman", "Singh", "Sales"),
            new Employee("Deepa", "Kumar", "IT")
        );

        String result = employees.stream()
            .map(e -> e.firstName + " " + e.lastName)
            .collect(Collectors.joining(" | "));

        System.out.println(result);
    }
}
