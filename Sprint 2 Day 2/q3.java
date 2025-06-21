public class Q3 {
    public static void main(String[] args) {
        Map<String, List<Employee>> deptMap = new HashMap<>();
        deptMap.put("Sales", List.of(new Employee("John", "Doe", "Sales")));
        deptMap.put("HR", List.of(new Employee("Alice", "Smith", "HR"), new Employee("Jade", "Ray", "HR")));

        String search = "ja";

        List<Employee> result = deptMap.values().stream()
            .flatMap(List::stream)
            .filter(emp -> emp.firstName.toLowerCase().contains(search) ||
                           emp.lastName.toLowerCase().contains(search))
            .collect(Collectors.toList());

        result.forEach(e -> System.out.println(e.firstName + " " + e.lastName));
    }
}
