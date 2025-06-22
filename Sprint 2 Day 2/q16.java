import java.util.*;

class Employee {
    String name;
    Optional<String> department;
    double salary;

    Employee(String name, String dept, double salary) {
        this.name = name;
        this.department = Optional.ofNullable(dept);
        this.salary = salary;
    }
}

public class Q16 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Arjun", "IT", 50000),
            new Employee("Priya", "HR", 55000),
            new Employee("Rahul", "IT", 60000)
        );

        for (Employee e : employees) {
            e.department.ifPresent(dept -> {
                if (dept.equalsIgnoreCase("IT")) {
                    e.salary += 5000;
                }
            });
        }

        employees.forEach(e -> System.out.println(e.name + " - " + e.salary));
    }
}
