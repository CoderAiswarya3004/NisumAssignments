class Parent {
    void parentMethod() {
        System.out.println("Method from Parent class");
    }
}

class Child extends Parent {
    void childMethod() {
        System.out.println("Method from Child class");
    }
}

public class MethodCallTest {
    public static void main(String[] args) {
        Parent ref = new Child();
        ref.parentMethod();
        // ref.childMethod(); // Compile-time error: method not found in Parent
    }
}
