import java.util.*;
import java.util.stream.Collectors;

class Address {
    String city, country;

    Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return city + ", " + country;
    }
}

class EmployeeAddr {
    String firstName, lastName;
    Address address;

    EmployeeAddr(String first, String last, Address addr) {
        this.firstName = first;
        this.lastName = last;
        this.address = addr;
    }

    String getFullName() {
        return firstName + lastName;
    }

    Address getAddress() {
        return address;
    }
}

public class Q18 {
    public static void main(String[] args) {
        List<EmployeeAddr> employees = Arrays.asList(
            new EmployeeAddr("Judith", "Donalad", new Address("New York", "USA")),
            new EmployeeAddr("Steve", "Smith", new Address("London", "UK")),
            new EmployeeAddr("Jiah", "Khan", new Address("Delhi", "India"))
        );

        Map<String, Address> result = employees.stream()
            .collect(Collectors.toMap(
                emp -> emp.getFullName(),
                emp -> emp.getAddress()
            ));

        result.forEach((k, v) -> System.out.println(k + " → " + v));
    }
}
