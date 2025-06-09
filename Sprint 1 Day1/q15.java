class Nisum {
    protected String companyName = "Nisum";
    protected int employeeCount = 1000;
}

class Employee extends Nisum {
    void display() {
        System.out.println("Company: " + companyName);
        System.out.println("Employees: " + employeeCount);
    }
}

public class Test {
    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.display();
    }
}
