class Address {
    String city;
    String country;

    Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    public String toString() {
        return city + ", " + country;
    }
}

public class Q17 {
    public static void main(String[] args) {
        List<Address> addresses = new ArrayList<>(List.of(
            new Address("Mumbai", "India"),
            new Address("Berlin", "Germany"),
            new Address("Mumbai", "USA"),
            new Address("Paris", "France")
        ));

        addresses.sort(Comparator.comparing((Address a) -> a.city)
                .thenComparing(a -> a.country));

        addresses.forEach(System.out::println);
    }
}
