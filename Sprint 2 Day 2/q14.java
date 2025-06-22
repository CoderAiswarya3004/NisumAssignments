class EmployeeOpt {
    String name;
    Optional<String> address;

    EmployeeOpt(String name, Optional<String> address) {
        this.name = name;
        this.address = address;
    }
}

public class Q14 {
    public static void main(String[] args) {
        List<EmployeeOpt> employees = List.of(
            new EmployeeOpt("Ravi", Optional.of("Mumbai")),
            new EmployeeOpt("Priya", Optional.empty())
        );

        for (EmployeeOpt e : employees) {
            String addr = e.address.orElse("Address not provided");
            System.out.println(e.name + " - " + addr);
        }
    }
}
