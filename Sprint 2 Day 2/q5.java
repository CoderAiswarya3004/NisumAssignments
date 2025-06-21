public class Q5 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("John", "Doe", "Sales"),
            new Employee("Alice", "Smith", "HR"),
            new Employee("Bob", "Ray", "Sales")
        );

        String excludeDept = "Sales";

        List<Employee> result = employees.stream()
            .filter(emp -> !emp.department.equalsIgnoreCase(excludeDept))
            .collect(Collectors.toList());

        result.forEach(e -> System.out.println(e.firstName + " " + e.lastName));
    }
}
