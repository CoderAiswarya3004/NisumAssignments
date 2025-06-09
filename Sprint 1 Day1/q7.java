public class Student {

    String name;
    String address;
    String section;
    String Year;

    static String college;
    static int rollNo;

    static {
        college = "KIIT";
        rollNo = 3658;
    }

    public Student(String name, String address, String section, String Year) {
        this.name = name;
        this.address = address;
        this.section = section;
        this.Year= Year;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Section: " + section);
        System.out.println("Year: " + Year);
        System.out.println("College: " + college);
        System.out.println("Roll No: " + rollNo);
    }

    public static void main(String[] args) {
        Student s1 = new Student("Aiswarya", "BBSR", "A", "4th");
        s1.displayInfo();
    }
}
