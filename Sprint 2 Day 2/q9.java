public class Q9 {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("A", "B", "Dept1"),
            new Employee("C", "D", "Dept2"),
            new Employee("E", "F", "Dept3"),
            new Employee("G", "H", "Dept4"),
            new Employee("I", "J", "Dept5"),
            new Employee("K", "L", "Dept6"),
            new Employee("M", "N", "Dept7"),
            new Employee("O", "P", "Dept8"),  // 8th
            new Employee("Q", "R", "Dept9"),
            new Employee("S", "T", "Dept10")
        );

        if (employees.size() >= 8) {
            Employee emp = employees.get(7);
            System.out.println(emp.firstName + " " + emp.lastName + " - " + emp.department);
        } else {
            System.out.println("List is too short.");
        }
    }
}
