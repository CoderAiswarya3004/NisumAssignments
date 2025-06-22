public class Q19 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("Nikhil", "IT", 50000),
            new Employee("Neha", "HR", 55000),
            new Employee("Ramesh", "IT", 60000)
        );

        employees.stream().findFirst().ifPresent(e -> System.out.println("First: " + e.name));
        employees.stream().findAny().ifPresent(e -> System.out.println("Any: " + e.name));
    }
}
