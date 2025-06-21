import java.util.*;
import java.util.stream.*;

class Employee {
    String name, gender;
    double salary;

    Employee(String name, String gender, double salary) {
        this.name = name;
        this.gender = gender;
        this.salary = salary;
    }
}

public class Q11 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Jitun", "Male", 50000),
            new Employee("Alica", "Female", 60000),
            new Employee("Micky", "Male", 70000),
            new Employee("Lily", "Female", 55000)
        );

        Map<String, Long> genderCount = employees.stream()
            .collect(Collectors.groupingBy(e -> e.gender, Collectors.counting()));

        System.out.println(genderCount);
    }
}
