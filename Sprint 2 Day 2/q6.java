import java.util.*;

public class Q6 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Ravi", "Patel", "HR"),
            new Employee("Aman", "Singh", "Sales"),
            new Employee("Deepa", "Kumar", "IT")
        ));

        employees.sort((a, b) -> a.firstName.compareTo(b.firstName));

        employees.forEach(e -> System.out.println(e.firstName + " " + e.lastName));
    }
}
