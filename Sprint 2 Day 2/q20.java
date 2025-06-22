class EmpCheck {
    String name, department, email;

    EmpCheck(String name, String department, String email) {
        this.name = name;
        this.department = department;
        this.email = email;
    }
}

public class Q20 {
    public static void main(String[] args) {
        List<EmpCheck> employees = List.of(
            new EmpCheck("Amit", "HR", "amit@mail.com"),
            new EmpCheck("Rina", "IT", "rina@mail.com"),
            new EmpCheck("Sam", "Sales", "sam@mail.com")
        );

        boolean hasHR = employees.stream().anyMatch(e -> "HR".equalsIgnoreCase(e.department));
        boolean allHaveEmail = employees.stream().allMatch(e -> e.email != null);
        boolean noneNullName = employees.stream().noneMatch(e -> e.name == null);

        System.out.println("Any from HR? " + hasHR);
        System.out.println("All have email? " + allHaveEmail);
        System.out.println("None has null name? " + noneNullName);
    }
}
