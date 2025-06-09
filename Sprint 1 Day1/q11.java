public class StaticOverload {

    static void display() {
        System.out.println("No arguments");
    }

    static void display(int a) {
        System.out.println("Integer argument: " + a);
    }

    static void display(String s) {
        System.out.println("String argument: " + s);
    }

    public static void main(String[] args) {
        display();
        display(10);
        display("Hello");
    }
}
