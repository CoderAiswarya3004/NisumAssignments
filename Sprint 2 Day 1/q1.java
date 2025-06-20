@FunctionalInterface
interface MyPrinter {
    void print(String message); 
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        
        MyPrinter printer = (msg) -> System.out.println("Message: " + msg);

        printer.print("Hello from a functional interface!");
    }
}
