public class StaticFlow{

    static int num = initializeStaticVar();

    static {
        System.out.println("Inside static block");
    }

    static int initializeStaticVar() {
        System.out.println("Static variable initialized");
        return 10;
    }

    static void display() {
        System.out.println("Inside static method");
    }

    public static void main(String[] args) {
        System.out.println("Inside main method");
        display();
        System.out.println("Static variable value: " + num);
    }
}
