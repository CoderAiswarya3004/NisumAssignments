class Parent {
    static void showMessage() {
        System.out.println("Static method in Parent class");
    }
}

class Child extends Parent {
    void callParentStatic() {
        Parent.showMessage();
    }
}

public class StaticAccess{
    public static void main(String[] args) {
        Child c = new Child();
        c.callParentStatic();
    }
}
