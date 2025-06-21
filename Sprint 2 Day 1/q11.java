interface A {
    default void run() {
        System.out.println("Running from A");
    }
}

interface B {
    default void run() {
        System.out.println("Running from B");
    }
}

public class Runner implements A, B {
    public void run() {
        A.super.run(); // Resolving the conflict by choosing A's run()
    }

    public static void main(String[] args) {
        new Runner().run(); // Output: Running from A
    }
}
