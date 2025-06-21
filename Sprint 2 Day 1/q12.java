interface Printer {
    default void print() {
        System.out.println("Default print from interface");
    }
}

public class MyPrinter implements Printer {
    public void print() {
        System.out.println("Custom print in class");
        Printer.super.print(); 
    }

    public static void main(String[] args) {
        new MyPrinter().print();
    }
}
