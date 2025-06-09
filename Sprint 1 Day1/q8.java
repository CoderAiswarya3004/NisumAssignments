public class StaticBlock{

    static int value;

    static {
        System.out.println("Static block executed");
        value = 42;
    }

    public static void main(String[] args) {
        System.out.println("Main method started");
        System.out.println("Value: " + value);
    }
}
