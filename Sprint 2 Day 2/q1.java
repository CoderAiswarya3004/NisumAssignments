import java.util.*;

class Employee {
    String firstName;
    String lastName;
    String department;

    Employee(String firstName, String lastName, String dept) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = dept;
    }
}

public class Q1 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("John", "Doe", "Sales"),
            new Employee("Alice", "Smith", "HR")
        );

        employees.stream().findFirst().ifPresent(emp ->
            System.out.println(emp.firstName + " " + emp.lastName)
        );
    }
}
