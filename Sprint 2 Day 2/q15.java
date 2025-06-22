public class Q15 {
    public static void main(String[] args) {
        List<EmployeeOpt> employees = List.of(
            new EmployeeOpt("Ravi", Optional.of("Delhi")),
            new EmployeeOpt("Neha", Optional.empty())
        );

        for (EmployeeOpt e : employees) {
            String addr = e.address.orElse("Nisum HQ - Hyderabad");
            System.out.println(e.name + " - " + addr);
        }
    }
}
