public class Q10 {
    public static void main(String[] args) {
        List<Integer> targetIds = List.of(101, 103);

        List<Employee> employees = List.of(
            new Employee(101, "Aman", "Kumar", "HR"),
            new Employee(102, "Riya", "Sharma", "Sales"),
            new Employee(103, "Ravi", "Patel", "IT")
        );

        List<Employee> matching = employees.stream()
            .filter(emp -> targetIds.contains(emp.empId))
            .collect(Collectors.toList());

        matching.forEach(e -> System.out.println(e.firstName + " " + e.lastName));
    }
}
