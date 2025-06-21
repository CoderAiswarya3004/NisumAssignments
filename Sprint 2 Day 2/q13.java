public class Q13 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>(List.of(
            new Employee("Jitun", "Male", 50000),
            new Employee("Alica", "Female", 60000),
            new Employee("Micky", "Male", 70000),
            new Employee("Lily", "Female", 55000)
        ));

        employees.sort(Comparator.comparingDouble(e -> e.salary));

        for (Employee e : employees) {
            System.out.println(e.name + " - ₹" + e.salary);
        }
    }
}
