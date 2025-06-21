import java.util.*;
import java.util.stream.*;

public class Q2 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Rishab", "Pant", "Sales"),
            new Employee("Chandu", "Singh", "HR"),
            new Employee("Bobby", "Ray", "Sales")
        );

        Map<String, Long> departmentCount = employees.stream()
            .collect(Collectors.groupingBy(emp -> emp.department, Collectors.counting()));

        System.out.println(departmentCount); // {HR=1, Sales=2}
    }
}
