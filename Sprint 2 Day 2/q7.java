class Employee {
    String firstName, lastName, department;
    int empId;

    Employee(int id, String fn, String ln, String dept) {
        empId = id;
        firstName = fn;
        lastName = ln;
        department = dept;
    }
}

public class Q7 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee(101, "Ravi", "Patel", "HR"),
            new Employee(105, "Aman", "Singh", "Sales"),
            new Employee(102, "Deepa", "Kumar", "IT")
        );

        employees.stream()
            .max(Comparator.comparingInt(e -> e.empId))
            .ifPresent(e -> System.out.println(e.firstName + " " + e.lastName + " - " + e.empId));
    }
}
