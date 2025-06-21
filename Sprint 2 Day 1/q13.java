interface Greet {
    default void sayHello() {
        System.out.println("Hello from interface");
    }
}

public class Greeter implements Greet {
    public void sayHello() {
        System.out.println("Hello from class");
        Greet.super.sayHello(); 
    }

    public static void main(String[] args) {
        new Greeter().sayHello();
    }
}
